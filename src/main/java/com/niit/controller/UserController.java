package com.niit.controller;
import cn.yangjunda.hibernate_pagehelper.PageInfo;
import com.niit.ImageUtils.ImgCut;
import com.niit.POJO.*;
import com.niit.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/forregister",method = RequestMethod.POST)
    public String register(User newUser,String vs1){
        //        MD5加密
        String pswd= DigestUtils.md5Hex(newUser.getUser_Password());
        newUser.setUser_Password(pswd);
        userService.addUser(newUser);
//        if (vs1.equals("Financier"))
//            userService.addFinancier(newUser.User_ID);
//        else
//            userService.addInvestor(newUser.User_ID);
         userService.addFinancier(newUser.User_ID);
         userService.addInvestor(newUser.User_ID);
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginUser(String id, String pwd, Model model, HttpSession httpSessions){
        httpSessions.removeAttribute("s1");
        // MD5 密码匹配
        String mdpwd=DigestUtils.md5Hex(pwd);
        User user=userService.validateUser(id,mdpwd);
        if (user==null){
            return "fail";
        }
        else {
            model.addAttribute("user",user);
            httpSessions.setAttribute("s1",user);

            String Type=userService.findUserType(id);
            httpSessions.setAttribute("s2",Type);


            model.addAttribute("Type",Type);
            if (Type.equals("Investor")){
                Investor investor=userService.getInvestorByID(id);
                model.addAttribute("Investor",investor);
                httpSessions.setAttribute("s3",investor);
            }
            else {
                Financier financier=userService.getFinancierByID(id);
                model.addAttribute("Financier",financier);
                httpSessions.setAttribute("s3",financier);
            }
            ArrayList<Item> items=userService.getItems();
            model.addAttribute("allitem",items);
            return "redirect:success";
        }
    }

    @RequestMapping(value = "/forgetpass",method = RequestMethod.POST)
    public String forgetpass(String forget_username, String forget_password,String forget_phone){
        User user = userService.validatePhone(forget_username,forget_phone);
        if (user == null){
            return "fail";
        }
        else{
            String mdpwd = DigestUtils.md5Hex(forget_password);
            user.setUser_Password(mdpwd);
            userService.updateUser(user);
            return "index";
        }
    }

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String sU(HttpSession httpSessions,Model model) {
        if (httpSessions.getAttribute("s1")==null)
            return "redirect:index.htm";
        User user=(User)httpSessions.getAttribute("s1");
        if (httpSessions.getAttribute("s2").equals("Investor")){
            Investor investor=(Investor)httpSessions.getAttribute("s3");
            model.addAttribute("Investor",investor);
            model.addAttribute("Flag",false);
        }
        else{
            Financier financier=(Financier)httpSessions.getAttribute("s3");
            model.addAttribute("Financier",financier);
            model.addAttribute("Flag",true);
        }
        model.addAttribute("Type",httpSessions.getAttribute("s2"));
        model.addAttribute("user",user);
        return "success";
    }


    @RequestMapping(value = "/showItem",method = RequestMethod.GET)
    public String Show(Integer ID,Model model,HttpSession httpSessions){
        Item item_copy=userService.getItemByID(ID);
        httpSessions.setAttribute("IC",item_copy);
        String Type=userService.getItemType(item_copy.getItem_Type());
        model.addAttribute("item_copy",item_copy);
        User user=(User)httpSessions.getAttribute("s1");
        User user_update=userService.getUserByID(user.getUser_ID());
        httpSessions.setAttribute("s1",user_update);
        user=(User)httpSessions.getAttribute("s1");
        User owner=userService.getItemOwner(item_copy.getItem_ID());


        ArrayList<Item_Comment> item_comments=userService.findCommentByID(item_copy.getItem_ID());
        HashSet<Item_Comment> item_comment=new HashSet<>(item_comments);
        model.addAttribute("commentSet",item_comment);

        model.addAttribute("user",user);
        model.addAttribute("owner",owner);
        model.addAttribute("type",Type);
        model.addAttribute("comments",item_comments);

        double rate=(item_copy.getItem_DemandMoney()-item_copy.getItem_StillDemandMoney())*100/item_copy.getItem_DemandMoney();
        BigDecimal bg = new BigDecimal(rate);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        model.addAttribute("rate",f1);


        if (user.getUser_ID().equals(owner.getUser_ID()))
            model.addAttribute("isMine",true);
        else
            model.addAttribute("isMine",false);

        return "showItem";
    }

    @RequestMapping(value = "/MyPage_Investor",method = RequestMethod.GET)
    public String GotoMyPage(Model model,HttpSession httpSessions){
        if (httpSessions.getAttribute("s1")==null)
            return "redirect:index.htm";
        User user=(User)httpSessions.getAttribute("s1");
        user=userService.getUserByID(user.User_ID);
        model.addAttribute("user",user);
        ArrayList<Item> itemlist=userService.check_Financier_Item(user.getUser_ID());
        HashSet<Item> itemSet=new HashSet<>(itemlist);
        model.addAttribute("itemSet",itemSet);
        return "MyPage_Investor";
    }

    @RequestMapping(value = "/MyPage_Supporter",method = RequestMethod.GET)
    public ModelAndView GotoMyPage_(Model model, HttpSession httpSessions){
        if (httpSessions.getAttribute("s1")==null)
//            return "redirect:index.htm";
            return new ModelAndView("index");
        ModelAndView modelAndView=new ModelAndView("MyPage_Supporter");

        User user=(User)httpSessions.getAttribute("s1");

        user=userService.getUserByID(user.User_ID);
        model.addAttribute("user",user);
        ArrayList<Item> itemlist=userService.check_Support_Item(user.getUser_ID());

        HashSet<Item> itemSet=new HashSet<>(itemlist);
        model.addAttribute("itemSet",itemSet);

        HashMap<String,Double> map=userService.getMyItemByID(user.getUser_ID());
//        model.addAttribute("map",map);
        modelAndView.addObject("map",map);


        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            modelAndView.addObject("map"+key.toString(),val.toString());
        }
//        return "MyPage_Supporter";
        return modelAndView;
    }
//
//    @RequestMapping(value = "/lists_support",method = RequestMethod.POST)
//    @ResponseBody
//    public PageInfo AjaxItem_support(HttpServletRequest httpServletRequest,Model model,HttpSession httpSessions){
//        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
//        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
//        User user=(User)httpSessions.getAttribute("s1");
//        model.addAttribute("user",user);
//        PageInfo pageInfo = userService.get_support(pageNum, pageSize, user.getUser_ID());
//        return pageInfo;
//    }

    @RequestMapping(value = "/showMySupport",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo showmyInvestor(HttpServletRequest httpServletRequest,HttpSession httpSessions,Model model){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        User user=(User)httpSessions.getAttribute("s1");
        PageInfo pageInfo = userService.getAllMySupport(pageNum, pageSize,user.getUser_ID());

        return pageInfo;
    }

    @RequestMapping(value = "/showMyInvest",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo showmyFinancier(HttpServletRequest httpServletRequest,HttpSession httpSessions){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        User user=(User)httpSessions.getAttribute("s1");
        PageInfo pageInfo = userService.getAllMyInvest(pageNum, pageSize,user.getUser_ID());

        return pageInfo;
    }
    @RequestMapping(value = "/showComment",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo showComment(HttpServletRequest httpServletRequest,HttpSession httpSessions){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));

        Integer ID = Integer.valueOf(httpServletRequest.getParameter("ID"));
        PageInfo pageInfo = userService.getAllComment(pageNum, pageSize,ID);

        return pageInfo;
    }





    @RequestMapping(value = "/ItemSupport",method = RequestMethod.GET)
    public String ShowSupport(Integer ID,Model model,HttpSession httpSessions){
        Item item_copy=userService.getItemByID(ID);
        User user=(User)httpSessions.getAttribute("s1");
        model.addAttribute("user",user);
        model.addAttribute("item_copy",item_copy);
        model.addAttribute("money",0.0);
        return "ItemSupport";
    }



    @RequestMapping(value = "/addItem",method = RequestMethod.GET)
    public String AddItem(Model model,HttpSession httpSessions){
        User user=(User)httpSessions.getAttribute("s1");
        model.addAttribute("user",user);
        return "addItem";
    }

    @RequestMapping(value = "/deposit",method = RequestMethod.GET)
    public String Deposit(Model model,HttpSession httpSessions){
        User user=(User)httpSessions.getAttribute("s1");
        model.addAttribute("user",user);
        return "deposit";
    }

    @RequestMapping(value = "/support",method = RequestMethod.POST)
    public String support(String itemid,String money,String userid,Model model){
        userService.AlterDemand(Integer.parseInt(itemid),Double.parseDouble(money),userid);
        return "redirect:success.htm";
    }


    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public String addComment(Integer itemID,String item_comment,HttpSession httpSession){
        User user=(User)httpSession.getAttribute("s1");
        Date comment_Date=new Date();
        userService.addComment(itemID,user.getUser_ID(),item_comment,comment_Date);
        return "redirect:success.htm";
    }


    @RequestMapping(value = "/addmoney",method = RequestMethod.POST)
    public String addmoney(Double Deposit_Money,HttpSession httpSession) throws Exception {
        User user=(User)httpSession.getAttribute("s1");
        String CurrencyType=userService.getCurrencyType(user.getUser_Country());
        //WebService
        String uri="http://www.apilayer.net/api/live?access_key=6b154f2c747e2e4a5216c0e1d15207a9";
        URL request_uri=new URL(uri+"&currencies="+CurrencyType+"&format=1");

        HttpURLConnection Connection=(HttpURLConnection) request_uri.openConnection();

        BufferedReader reader=new BufferedReader(new InputStreamReader(Connection.getInputStream()));
        StringBuilder data=new StringBuilder();
        String line;
        while ((line=reader.readLine())!=null)
            data.append(line);

        JSONObject jsonObject = JSONObject.fromObject(data.toString());
        String quotes=jsonObject.getString("quotes");

        JSONObject jsonObject2 = JSONObject.fromObject(quotes);
        String ratio=jsonObject2.getString("USD"+CurrencyType);

        Double acutulRatio=Double.parseDouble(ratio);
        acutulRatio=1/acutulRatio;
        BigDecimal bg = new BigDecimal(acutulRatio);
        acutulRatio= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        userService.addMoney(user.getUser_ID(),Deposit_Money*acutulRatio);

        return "redirect:success.htm";
    }

    @RequestMapping(value = "/addi",method = RequestMethod.POST)
    public String addi(Item item,HttpSession httpSession) throws Exception {

        item.setItem_EstablishDate(new Date());
        item.setItem_StillDemandMoney(item.getItem_DemandMoney());
        item.setItem_SupporterNumber(item.getItem_SupporterNumber());
        item.setItem_LikerNumeber(0);
        User user=(User)httpSession.getAttribute("s1");


        String CurrencyType=userService.getCurrencyType(user.getUser_Country());
        //WebService
        String uri="http://www.apilayer.net/api/live?access_key=6b154f2c747e2e4a5216c0e1d15207a9";
        URL request_uri=new URL(uri+"&currencies="+CurrencyType+"&format=1");

        HttpURLConnection Connection=(HttpURLConnection) request_uri.openConnection();

        BufferedReader reader=new BufferedReader(new InputStreamReader(Connection.getInputStream()));
        StringBuilder data=new StringBuilder();
        String line;
        while ((line=reader.readLine())!=null)
            data.append(line);

        JSONObject jsonObject = JSONObject.fromObject(data.toString());
        String quotes=jsonObject.getString("quotes");

        JSONObject jsonObject2 = JSONObject.fromObject(quotes);
        String ratio=jsonObject2.getString("USD"+CurrencyType);

        Double acutulRatio=Double.parseDouble(ratio);

        acutulRatio=1/acutulRatio;

        BigDecimal bg = new BigDecimal(acutulRatio);
        acutulRatio= bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


//        acutulRatio=1/acutulRatio;


        item.setItem_DemandMoney(item.getItem_DemandMoney()*acutulRatio);
        item.setItem_StillDemandMoney(item.getItem_StillDemandMoney()*acutulRatio);

        userService.saveItem(item,user.User_ID);

        String des="/Users/henry_fordham/Desktop/项目/QianQianInvestment/src/main/webapp/images/B"+item.getItem_ID()+".jpg";
        ImgCut.zoomImage(des,des,360,240);

        return "redirect:success.htm";
    }

    @RequestMapping(value = "/lists",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo AjaxItem(HttpServletRequest httpServletRequest){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        PageInfo pageInfo = userService.getAll(pageNum, pageSize);
        return pageInfo;
    }

    @RequestMapping(value = "/lists_catalog1",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo AjaxItem_catalog1(HttpServletRequest httpServletRequest){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        PageInfo pageInfo = userService.get_catalog(pageNum, pageSize,1);
        return pageInfo;
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo AjaxItem_search(HttpServletRequest httpServletRequest){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        String content = httpServletRequest.getParameter("content");

        PageInfo pageInfo = userService.search(pageNum, pageSize,content);
        return pageInfo;
    }


    @RequestMapping(value = "/lists_catalog2",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo AjaxItem_catalog2(HttpServletRequest httpServletRequest){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        PageInfo pageInfo = userService.get_catalog(pageNum, pageSize,2);
        return pageInfo;
    }

    @RequestMapping(value = "/addNum",method=RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> addNum(int id,int num){
        HashMap<String,String> map = new HashMap<>();
        try{
            userService.addNum(id,num);
            map.put("code","1");
        }catch (Exception e){
            map.put("code","2");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/lists_catalog3",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo AjaxItem_catalog3(HttpServletRequest httpServletRequest){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        PageInfo pageInfo = userService.get_catalog(pageNum, pageSize,3);
        return pageInfo;
    }

    @RequestMapping(value = "/lists_catalog4",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo AjaxItem_catalog4(HttpServletRequest httpServletRequest){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        PageInfo pageInfo = userService.get_catalog(pageNum, pageSize,4);
        return pageInfo;
    }

    @RequestMapping(value = "/lists_catalog5",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo AjaxItem_catalog5(HttpServletRequest httpServletRequest){
        Integer pageNum = Integer.valueOf(httpServletRequest.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(httpServletRequest.getParameter("pageSize"));
        PageInfo pageInfo = userService.get_catalog(pageNum, pageSize,5);
        return pageInfo;
    }
}

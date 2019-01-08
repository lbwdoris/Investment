package com.niit.ImageUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.niit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller

/*@RequestMapping("/UploadDemo")*/
public class UploadImgController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/uploadHeadImage",method = RequestMethod.GET)
    public String uploadCropper(){
        return "cropper";
    }

    @RequestMapping(value = "/uploadHeadImage",method = RequestMethod.POST, produces="text/html;charset=utf-8")
    @ResponseBody
    public String uploadCropper(
            @RequestParam(value = "avatar_file",required=false) MultipartFile avatar_file,
            String avatar_src,String avatar_data, HttpServletRequest request) throws Exception {
        System.out.println("==========Start=============");
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String resourcePath = "/images/";
        //判断文件的MIMEtype
        String type = avatar_file.getContentType();
        if(type==null || !FileUploadUtil.allowUpload(type)) return  JSON.toJSONString(new Result(null,"不支持的文件类型，仅支持图片！"));
        System.out.println("file type:"+type);
        String fileName = FileUploadUtil.rename(avatar_file.getOriginalFilename());
        int end = fileName.lastIndexOf(".");
        int num=userService.getAllItemsNum()+1;
        String saveName = num+"";
        try {
            File dir = new File(realPath + resourcePath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            File file = new File(dir,"B"+saveName+"_src.jpg");

            avatar_file.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
            return  JSON.toJSONString(new Result(null,"上传失败，出现异常："+e.getMessage()));
        }
        String srcImagePath = realPath + resourcePath + "B"+saveName;
        JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
        // 用户经过剪辑后的图片的大小
        // 用户经过剪辑后的图片的大小
        float x = joData.getFloatValue("x");
        float y = joData.getFloatValue("y");
        float w =  joData.getFloatValue("width");
        float h =  joData.getFloatValue("height");
        float r = joData.getFloatValue("rotate");
        System.out.println(x+" "+y+" "+w+" "+h);
        //这里开始截取操作
        System.out.println("==========imageCutStart=============");
        ImgCut.cutAndRotateImage(srcImagePath, (int)x,(int) y,(int) w,(int) h,(int) r);
        System.out.println("==========imageCutEnd=============");
        System.out.println(request.getSession().getServletContext().getContextPath()+resourcePath+"B"+saveName+".jpg");
        File f=new File("/Users/henry_fordham/Desktop/项目/QianQianInvestment/src/main/webapp/images/"+"B"+saveName+".jpg");

        System.out.println(f.getPath());
        try {
            BufferedImage bi = ImageIO.read(new URL("http://localhost:8080"+request.getSession().getServletContext().getContextPath() + resourcePath + "B"+saveName + ".jpg"));
            System.out.println("http://localhost:8080"+request.getSession().getServletContext().getContextPath() + resourcePath + "B"+saveName + ".jpg");
            ImageIO.write(bi,"jpg",f);
            ImgCut.zoomImage("/Users/henry_fordham/Desktop/项目/QianQianInvestment/src/main/webapp/images/"+"B"+saveName+".jpg","/Users/henry_fordham/Desktop/项目/QianQianInvestment/src/main/webapp/images/"+"B"+saveName+".jpg",360,240);
        }
        catch(Exception e)
        {
            System.out.println(e);
            //System.out.println(f.getParent());
        }
        System.out.println(request.getSession().getServletContext().getContextPath() + "3"+resourcePath +"3"+ saveName + ".jpg");

        return  JSON.toJSONString(new Result(request.getSession().getServletContext().getContextPath()+resourcePath+  "B"+saveName + ".jpg","上传成功!"));
    }

}

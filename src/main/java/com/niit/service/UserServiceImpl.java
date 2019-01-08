package com.niit.service;

import cn.yangjunda.hibernate_pagehelper.PageInfo;
import com.niit.POJO.*;
import com.niit.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public void addMoney(String User_ID, Double Money) {
        userDAO.addMoney(User_ID,Money);
    }

    @Override
    public String getItemType(int id) {
        return userDAO.getItemType(id);
    }

    @Override
    public PageInfo getAllMySupport(int pageNum, int pageSize,String userid) {
        return userDAO.getAllMySupport(pageNum,pageSize,userid);
    }

    @Override
    public PageInfo getAllMyInvest(int pageNum, int pageSize,String userid) {
        return userDAO.getAllMyInvest(pageNum,pageSize,userid);
    }

    @Override
    public PageInfo getAllComment(int pageNum,int pageSize,Integer item_id) {
        return userDAO.getAllComment(pageNum,pageSize,item_id);
    }

    @Override
    public HashMap<String,Double> getMyItemByID(String userID) {
        return userDAO.getMyItemByID(userID);
    }

    @Transactional(
//            propagation = Propagation.REQUIRED,
//            readOnly = true,
//            rollbackFor = {SQLException.class, IOException.class,RuntimeException.class},
//            isolation = Isolation.READ_COMMITTED
    )//I need Spring to manage the transaction

    @Override
    public void addUser(User user) {
        userDAO.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteUser(String UserID) {
        userDAO.delete(UserID);
    }

    @Override
    public ArrayList<User> getUsers() {
        return null;
    }

    @Override
    public ArrayList<Item> getItems() {
        return userDAO.getAllItems();
    }

    @Override
    public User validateUser(String UserID, String UserPass) {
        User user=userDAO.getAsUserByID(UserID);
        if (user!=null && user.getUser_Password().equals(UserPass))
            return user;
        return null;
    }

    @Override
    public User validatePhone(String UserID, String UserPhone) {
        User user = userDAO.getAsUserByID(UserID);
        if (user != null && user.getUser_Phone().equals(UserPhone))
            return user;
        return null;
    }
    @Override
    public int getAllItemsNum(){
        return userDAO.getAllItems().size();
    }

    @Override
    public User getItemOwner(int ItemID) {
        return userDAO.getItemOwner(ItemID);
    }

    @Override
    public String getCurrencyType(String Country) {
        return userDAO.getCurrencyType(Country);
    }

    @Override
    public PageInfo getAll(int pageNum,int pageSize) {
        return userDAO.getAll(pageNum, pageSize);
    }


    @Override
    public void addFinancier(String ID) {
        userDAO.addFinancier(ID);
    }

    @Override
    public void addInvestor(String ID) {
        userDAO.addInverstor(ID);
    }

    @Override
    public void addNum(int id,int num){
        userDAO.addNum(id,num);
    }

    @Override
    public Item getItemByID(int id) {
        return userDAO.getItemByID(id);
    }

    @Override
    public void AlterDemand(int id, double money,String userid) {
        userDAO.AlterDemand(id,money,userid);
    }

    @Override
    public String findUserType(String ID) {
        return userDAO.findUserType(ID);
    }

    @Override
    public Financier getFinancierByID(String ID) {
        return userDAO.getFinancierByID(ID);
    }

    @Override
    public Investor getInvestorByID(String ID) {
        return userDAO.getInvestorByID(ID);
    }

    @Override
    public User getUserByID(String UserID) {
        return userDAO.getUserByID(UserID);
    }

    @Override
    public PageInfo get_catalog(int pageNum, int pageSize, int catalognum) {
        return userDAO.get_catalog(pageNum,pageSize,catalognum);
    }

    @Override
    public void saveItem(Item item,String User_ID) {
        userDAO.saveItem(item,User_ID);
    }
    @Override
    public ArrayList<Item> check_Financier_Item(String UserID){
        return userDAO.check_Financier_Item(UserID);
    }

    @Override
    public ArrayList<Item> check_Support_Item(String UserID) {
        return userDAO.check_Supporter_Item(UserID);
    }

    @Override
    public PageInfo search(int pageNum, int pageSize,String content){
        return userDAO.search(pageNum,pageSize,content);
    }

    @Override
    public ArrayList<Item_Comment> findCommentByID(Integer Item_ID) {
        return userDAO.findCommentByID(Item_ID);
    }

    @Override
    public void addComment(Integer item_ID, String user_ID, String comment, Date comment_Date) {
        userDAO.addComment(item_ID,user_ID,comment,comment_Date);
    }
}

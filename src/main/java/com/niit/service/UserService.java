package com.niit.service;
import cn.yangjunda.hibernate_pagehelper.PageInfo;
import com.niit.POJO.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public interface UserService {
    void addUser(User user);
    void updateUser(User student);
    void deleteUser(String UserID);
    ArrayList<User> getUsers();
    ArrayList<Item> getItems();
    User validateUser(String UserID, String UserPass);
    User validatePhone(String UserID,String UserPhone);
    PageInfo getAll(int pageNum, int pageSize);
    void addFinancier(String ID);
    void addInvestor(String ID);
    void addNum(int id, int num);
    Item getItemByID(int id);
    void AlterDemand(int id, double money, String userid);
    String findUserType(String ID);
    Financier getFinancierByID(String ID);
    Investor getInvestorByID(String ID);
    User getUserByID(String UserID);
    PageInfo get_catalog(int pageNum, int pageSize, int catalognum);

    void saveItem(Item item_copy, String User_ID);
    ArrayList<Item>check_Financier_Item(String UserID);
    ArrayList<Item>check_Support_Item(String UserID);
    public int getAllItemsNum();
    User getItemOwner(int ItemID);
    String getCurrencyType(String Country);
    void addMoney(String User_ID, Double Money);
    String getItemType(int id);
    PageInfo getAllMySupport(int pageNum, int pageSize, String userid);
    PageInfo getAllMyInvest(int pageNum, int pageSize, String userid);
    PageInfo getAllComment(int pageNum,int pageSize,Integer item_id);
    HashMap<String,Double> getMyItemByID(String userID);
    PageInfo search(int pageNum, int pageSize,String content);

    ArrayList<Item_Comment> findCommentByID(Integer Item_ID);
    void addComment(Integer item_ID, String user_ID, String comment, Date comment_date);
}

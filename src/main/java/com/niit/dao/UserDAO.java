package com.niit.dao;

import cn.yangjunda.hibernate_pagehelper.PageInfo;
import com.niit.POJO.*;

import java.util.*;

public interface UserDAO {
    void insert(User user);
    void update(User user);
    void delete(String userID);
    User getAsUserByID(String ID);
    ArrayList<User> getAllUsers();
    ArrayList<Item> getAllItems();
    PageInfo getAll(int pageNum, int pageSize);
    void addFinancier(String ID);
    void addInverstor(String ID);
    void addNum(int id,int num);
    Item getItemByID(int id);
    void AlterDemand(int id,double money,String userid);

    String findUserType(String ID);
    User getUserByID(String UserID);


    Financier getFinancierByID(String ID);
    Investor getInvestorByID(String ID);
    public PageInfo get_catalog(int pageNum, int pageSize,int catalognum);

//    public PageInfo get_like(int pageNum, int pageSize, int UserID);
    void saveItem(Item item,String User_ID);
    ArrayList<Item> check_Financier_Item(String UserID);
    ArrayList<Item> check_Supporter_Item(String UserID);
    User getItemOwner(int ItemID);
    String getCurrencyType(String Country);
    void addMoney(String User_ID,Double Money);
    String getItemType(int id);
    PageInfo getAllMySupport(int pageNum, int pageSize,String userID);
    PageInfo getAllMyInvest(int pageNum, int pageSize,String userid);
    PageInfo getAllComment(int pageNum,int pageSize,Integer item_id);

    HashMap<String,Double> getMyItemByID(String userID);
    PageInfo search(int pageNum, int pageSize,String content);

    ArrayList<Item_Comment> findCommentByID(Integer Item_ID);
    void addComment(Integer item_ID,String user_ID,String comment,Date comment_Date);
}

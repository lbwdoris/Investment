package com.niit.dao;
import cn.yangjunda.hibernate_pagehelper.Page;
import cn.yangjunda.hibernate_pagehelper.PageHelper;
import cn.yangjunda.hibernate_pagehelper.PageInfo;
import com.niit.POJO.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Console;
import java.util.*;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory factory;

    @Override
    public void insert(User user) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

    @Override
    public void update(User user) {
        Session session=factory.getCurrentSession();
        Transaction tx= session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
    }

    @Override
    public void delete(String userID) {
        factory.getCurrentSession().delete(userID);
    }

    @Override
    public User getAsUserByID(String ID) {
        return factory.openSession().get(User.class,ID);
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) factory.getCurrentSession().createQuery("from Item").list();
    }

    @Override
    public ArrayList<Item> getAllItems() {
        return (ArrayList<Item>) factory.openSession().createQuery("from Item").list();
    }

    @Override
    public PageInfo getAll(int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        StringBuilder hql = new StringBuilder("from ").append("Item").append(" ");
        return new PageInfo(page,hql.toString());
    }

    @Override
    public PageInfo get_catalog(int pageNum, int pageSize,int catalognum) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        StringBuilder hql = new StringBuilder("from ").append("Item").append(" ");
        hql.append("where Item_Type='").append(catalognum).append("' ");
        return new PageInfo(page,hql.toString());
    }

    @Override
    public PageInfo search(int pageNum, int pageSize,String content){
        Page page = PageHelper.startPage(pageNum,pageSize);
        StringBuilder hql = new StringBuilder("from ").append("Item").append(" ");
        hql.append("where Item_Title like '").append("%").append(content).append("%").append("' ");
        return new PageInfo(page,hql.toString());
    }

    @Override
    public ArrayList<Item_Comment> findCommentByID(Integer Item_ID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        ArrayList<Item_Comment> item_comments= (ArrayList<Item_Comment>) session.createQuery("from Item_Comment where Item_ID=?").setParameter(0,Item_ID).list();

        tx.commit();
        return item_comments;
    }

    @Override
    public void addComment(Integer item_ID, String user_ID, String comment,Date comment_Date) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Item_Comment item_comment=new Item_Comment(item_ID,comment,user_ID,comment_Date);
        session.save(item_comment);
        tx.commit();
    }
//    @Override
//    public PageInfo get_launch(int pageNum, int pageSize, String UserID) {
//        Page page = PageHelper.startPage(pageNum, pageSize);
//        StringBuilder hql = new StringBuilder("from ").append("Item,Item_Owner").append(" ");
//        hql.append("where Item.Item_ID=Item_Owner.Item_ID and Item_Owner.User_ID= '").append(UserID).append("' ");
//        return new PageInfo(page,hql.toString());
//    }


//
//    @Override
//    public PageInfo get_like(int pageNum, int pageSize, int UserID) {
//        return null;
//    }


    @Override
    public void addFinancier(String ID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Financier financier=new Financier(ID);
        session.save(financier);
        tx.commit();
    }

    @Override
    public void addInverstor(String ID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Investor investor=new Investor(ID);
        session.save(investor);
        tx.commit();
    }
    @Override
    public void addNum(int id,int num){
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            Item item=session.load(Item.class,id);
            item.setItem_LikerNumeber(num);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Item getItemByID(int id) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            Item item=session.load(Item.class,id);
            Hibernate.initialize(item);
            tx.commit();
            return item;
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void AlterDemand(int itemid, double money,String userid) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{

            boolean haveInvest=false;
            ArrayList <Item_Supporters> item_supporters_list=(ArrayList<Item_Supporters>)session.createQuery("from Item_Supporters where Item_ID=? and Supporter_IDs=?").setParameter(0,itemid).setParameter(1,userid).list();
            Item_Supporters item_supporters=new Item_Supporters();

            if (item_supporters_list.size()==0)
                item_supporters=new Item_Supporters(itemid,userid,money);

            else {
                item_supporters=item_supporters_list.get(0);
                item_supporters.setSupport_Money(item_supporters.getSupport_Money() + money);
                haveInvest=true;
            }

            Item it2=session.get(Item.class,itemid);
            it2.setItem_StillDemandMoney(it2.getItem_StillDemandMoney()-money);
            if (!haveInvest)
                it2.setItem_SupporterNumber(it2.getItem_SupporterNumber()+1);
            session.save(item_supporters);

//            Query query=session.createQuery("update Item set Item_StillDemandMoney=? where Item_ID=?");
//            query.setParameter(0,it2.getItem_StillDemandMoney());
//            query.setParameter(1,itemid);
//            query.executeUpdate();
//
//            if (!haveInvest){
//                Query query2=session.createQuery("update Item set Item_SupporterNumber=? where Item_ID=?");
//                query.setParameter(0,it2);
//                query.setParameter(1,itemid);
//                query.executeUpdate();
//            }

            User user=session.get(User.class,userid);
            user.setUser_Balance(user.getUser_Balance()-money);
            session.saveOrUpdate(user);


//            Item item2=session.load(Item.class,itemid);
//            item2.setItem_StillDemandMoney(item2.getItem_StillDemandMoney()-money);
//            item2.setItem_SupporterNumber(item2.getItem_SupporterNumber()+1);
//
//            Investor investor=session.get(Investor.class,userid);
//            investor.setUser_InvestItemNumber(investor.getUser_InvestItemNumber()+1);
////            investor.getUser_InvestItemSet().add(item2);
//
//
//            Item_Supporters item_supporters=new Item_Supporters(itemid,userid,money);
//

//
//            session.saveOrUpdate(investor);

//            session.saveOrUpdate(item2);
//            session.saveOrUpdate(item_supporters);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public String findUserType(String ID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{

            if ((session.get(Investor.class,ID))==null){
                tx.commit();
                return "Financier";
            }

            else {
                tx.commit();
                return "Investor";
            }
        }
        catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        tx.commit();
        return null;
    }

    @Override
    public User getUserByID(String UserID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        User user=session.get(User.class,UserID);
        tx.commit();
        return user;
    }

    @Override
    public Financier getFinancierByID(String ID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Financier financier=session.get(Financier.class,ID);
        tx.commit();
        return financier;
    }

    @Override
    public Investor getInvestorByID(String ID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Investor investor=session.get(Investor.class,ID);
        tx.commit();
        return investor;
    }

    @Override
    public void saveItem(Item item,String User_ID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(item);

        Financier financier=session.get(Financier.class,User_ID);
        financier.setUser_IssueNumber(financier.getUser_IssueNumber()+1);


        Item_Owner item_owner=new Item_Owner(item.getItem_ID(),User_ID);
        session.save(item_owner);
        session.save(financier);

        tx.commit();
    }

    @Override
    public ArrayList<Item> check_Financier_Item(String UserID){
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        ArrayList<Item_Owner> item_owners= (ArrayList<Item_Owner>) session.createQuery("from Item_Owner where User_ID=?").setParameter(0,UserID).list();
        ArrayList<Item> itemArrayList=new ArrayList<>();
        for (Item_Owner item_owner:item_owners){
            Item item=session.load(Item.class,item_owner.getItem_ID());
            Hibernate.initialize(item);
            itemArrayList.add(item);
        }

        tx.commit();

        return itemArrayList;
    }

    @Override
    public ArrayList<Item> check_Supporter_Item(String UserID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        ArrayList<Item_Supporters> item_owners= (ArrayList<Item_Supporters>) session.createQuery("from Item_Supporters where Supporter_IDs=?").setParameter(0,UserID).list();
        ArrayList<Item> itemArrayList=new ArrayList<>();
        for (Item_Supporters item_owner:item_owners){
            Item item=session.load(Item.class,item_owner.getItem_ID());
            Hibernate.initialize(item);
            itemArrayList.add(item);
        }
        tx.commit();
        return itemArrayList;
    }

    @Override
    public PageInfo getAllMySupport(int pageNum, int pageSize,String userID) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        StringBuilder hql = new StringBuilder("from Item t where Item_ID=any(select s.Item_ID from Item_Supporters s where s.Supporter_IDs='").append(userID).append("')").append(" ");
        return new PageInfo(page,hql.toString());
    }

    @Override
    public PageInfo getAllMyInvest(int pageNum, int pageSize,String userID) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        StringBuilder hql = new StringBuilder("from Item t where Item_ID=any(select s.Item_ID from Item_Owner s where s.User_ID='").append(userID).append("')").append(" ");
        return new PageInfo(page,hql.toString());
    }

    @Override
    public PageInfo getAllComment(int pageNum,int pageSize,Integer item_id) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        StringBuilder hql = new StringBuilder("from Item_Comment where Item_ID='").append(item_id).append("'");

        return new PageInfo(page,hql.toString());
    }

    @Override
    public User getItemOwner(int ItemID) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Item_Owner item_owner=(Item_Owner)session.createQuery("from Item_Owner where Item_ID=?").setParameter(0,ItemID).uniqueResult();
        User user=session.get(User.class,item_owner.getUser_ID());
        tx.commit();
        return user;
    }

    @Override
    public String getCurrencyType(String Country) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Country_Currency country_currency=session.get(Country_Currency.class,Country);
        tx.commit();
        return country_currency.getCurrency_Type();
    }

    @Override
    public void addMoney(String User_ID, Double Money) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        User user=session.get(User.class,User_ID);
        user.setUser_Balance(user.getUser_Balance()+Money);
        session.saveOrUpdate(user);

        tx.commit();
    }

    @Override
    public String getItemType(int id) {
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        ItemType itemType=session.get(ItemType.class,id);

        tx.commit();
        return itemType.getType_Name();
    }

    @Override
    public HashMap<String,Double> getMyItemByID(String userID){
        Session session= factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        HashMap<String,Double> map= new HashMap<>();
        ArrayList<Item_Supporters> item_supporters=(ArrayList<Item_Supporters>)session.createQuery("from Item_Supporters where Supporter_IDs=?").setParameter(0,userID).list();

        for (Item_Supporters item_supporter:item_supporters)
            map.put(item_supporter.getItem_ID().toString(),item_supporter.getSupport_Money());

        tx.commit();
        return map;
    }


}

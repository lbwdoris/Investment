package com.niit.POJO;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item_Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Comment_ID;
    @Column
    private Integer Item_ID;
    @Column
    private String Comment;
    @Column
    private String User_ID;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date Comment_Date;

    public Date getComment_Date() {
        return Comment_Date;
    }

    public void setComment_Date(Date comment_Date) {
        Comment_Date = comment_Date;
    }

    public Item_Comment(String comment, Integer item_ID, String user_ID){}

    public Item_Comment(Integer item_ID, String comment, String user_ID, Date comment_Date) {
        Item_ID = item_ID;
        Comment = comment;
        User_ID = user_ID;
        Comment_Date = comment_Date;
    }

    public Item_Comment() {
    }

    public Integer getComment_ID() {
        return Comment_ID;
    }

    public void setComment_ID(Integer comment_ID) {
        Comment_ID = comment_ID;
    }

    public Integer getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(Integer item_ID) {
        Item_ID = item_ID;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }
}

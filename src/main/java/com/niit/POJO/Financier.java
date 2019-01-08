package com.niit.POJO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Financier implements Serializable{
    @Id
    public String User_ID;

    @Column
    public int User_IssueNumber;

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }



    public int getUser_IssueNumber() {
        return User_IssueNumber;
    }

    public void setUser_IssueNumber(int user_IssueNumber) {
        User_IssueNumber = user_IssueNumber;
    }

    public Financier(String User_ID) {
        this.User_ID= User_ID;
    }

    public Financier(){

    }
}


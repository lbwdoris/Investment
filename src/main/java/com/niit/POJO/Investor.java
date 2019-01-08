package com.niit.POJO;

import javax.persistence.*;

@Entity
public class Investor{
    @Id
    private String User_ID;
    @Column
    public int User_InvestItemNumber;

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }

    public int getUser_InvestItemNumber() {
        return User_InvestItemNumber;
    }

    public void setUser_InvestItemNumber(int user_InvestItemNumber) {
        User_InvestItemNumber = user_InvestItemNumber;
    }


    public Investor(String user_ID, int user_InvestItemNumber) {
        User_ID = user_ID;
        User_InvestItemNumber = user_InvestItemNumber;
    }

    public Investor(String user_ID){
        this.User_ID=user_ID;
    }

    public Investor() {
    }
}

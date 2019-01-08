package com.niit.POJO;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable{
    public String User_ID;
    public String User_Password;
    public String User_Name;
    public String User_Phone;
    public Double User_Balance;
    public String User_Country;

    public User() {
    }

    public User(String user_Country,String user_ID, String user_Password, String user_Name, String user_Phone, Double user_Balance) {
        User_Country=user_Country;
        User_ID = user_ID;
        User_Password = user_Password;
        User_Name = user_Name;
        User_Phone = user_Phone;
        User_Balance = user_Balance;
    }

    @Column
    public String getUser_Country() {
        return User_Country;
    }

    public void setUser_Country(String user_Country) {
        User_Country = user_Country;
    }

    @Id
    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }
    @Column
    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
    }
    @Column
    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }
    @Column
    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        User_Phone = user_Phone;
    }
    @Column
    public Double getUser_Balance() {
        return User_Balance;
    }

    public void setUser_Balance(Double user_Balance) {
        User_Balance = user_Balance;
    }
}

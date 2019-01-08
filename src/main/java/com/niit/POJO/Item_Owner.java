package com.niit.POJO;

import javax.persistence.*;

@Entity
public class Item_Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Item_Owner_ID;
    @Column
    private Integer Item_ID;
    @Column
    private String User_ID;

    public Item_Owner() {
    }

    public Item_Owner(Integer item_ID, String user_ID) {
        Item_ID = item_ID;
        User_ID = user_ID;
    }

    public Integer getItem_Owner_ID() {
        return Item_Owner_ID;
    }

    public void setItem_Owner_ID(Integer item_Owner_ID) {
        Item_Owner_ID = item_Owner_ID;
    }

    public Integer getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(Integer item_ID) {
        Item_ID = item_ID;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }
}

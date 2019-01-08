package com.niit.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemType {
    @Id
    private int Type_ID;
    @Column
    private String Type_Name;

    public ItemType() {
    }

    public int getType_ID() {
        return Type_ID;
    }

    public void setType_ID(int type_ID) {
        Type_ID = type_ID;
    }

    public String getType_Name() {
        return Type_Name;
    }

    public void setType_Name(String type_Name) {
        Type_Name = type_Name;
    }

    public ItemType(int type_ID, String type_Name) {
        Type_ID = type_ID;
        Type_Name = type_Name;
    }
}

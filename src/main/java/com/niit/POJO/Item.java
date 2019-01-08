package com.niit.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Item_ID;
    @Column
    public String Item_Title;
    @Column
    public String Item_Discription;
    @Column
    public Integer Item_Type;
    @Column
    public Double Item_DemandMoney;
    @Column
    public Double Item_StillDemandMoney;
    @Column
    public Integer Item_SupporterNumber;
    @Column
    public Integer Item_LikerNumeber;
    @Column
    @Type(type="text")
    public String Item_Detail;


    @Column
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date Item_EstablishDate;

//    Getter And Setter
    public Integer getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(Integer item_ID) {
        Item_ID = item_ID;
    }


    public String getItem_Title() {
        return Item_Title;
    }

    public void setItem_Title(String item_Title) {
        Item_Title = item_Title;
    }

    public String getItem_Discription() {
        return Item_Discription;
    }

    public void setItem_Discription(String item_Discription) {
        Item_Discription = item_Discription;
    }

    public Integer getItem_Type() {
        return Item_Type;
    }

    public void setItem_Type(Integer item_Type) {
        Item_Type = item_Type;
    }

    public Double getItem_DemandMoney() {
        return Item_DemandMoney;
    }

    public void setItem_DemandMoney(Double item_DemandMoney) {
        Item_DemandMoney = item_DemandMoney;
    }

    public Double getItem_StillDemandMoney() {
        return Item_StillDemandMoney;
    }

    public void setItem_StillDemandMoney(Double item_StillDemandMoney) {
        Item_StillDemandMoney = item_StillDemandMoney;
    }

    public Integer getItem_SupporterNumber() {
        return Item_SupporterNumber;
    }

    public void setItem_SupporterNumber(Integer item_SupporterNumber) {
        Item_SupporterNumber = item_SupporterNumber;
    }


    public Date getItem_EstablishDate() {
        return Item_EstablishDate;
    }

    public void setItem_EstablishDate(Date item_EstablishDate) {
        Item_EstablishDate = item_EstablishDate;
    }

    public String getItem_Detail() {
        return Item_Detail;
    }

    public void setItem_Detail(String item_Detail) {
        Item_Detail = item_Detail;
    }

    public Integer getItem_LikerNumeber() {
        return Item_LikerNumeber;
    }

    public void setItem_LikerNumeber(Integer item_LikerNumeber) {
        Item_LikerNumeber = item_LikerNumeber;
    }

    //Constructor
    public Item(Integer item_LikerNumeber,String item_Title, String item_Discription, Integer item_Type, Double item_DemandMoney, Double item_StillDemandMoney, Integer item_SupporterNumber, Date item_EstablishDate,String item_Detail) {
        Item_LikerNumeber = item_LikerNumeber;
        Item_Title = item_Title;
        Item_Discription = item_Discription;
        Item_Type = item_Type;
        Item_DemandMoney = item_DemandMoney;
        Item_StillDemandMoney = item_StillDemandMoney;
        Item_SupporterNumber = item_SupporterNumber;
        Item_EstablishDate = item_EstablishDate;
        Item_Detail = item_Detail;
    }

    public Item() {
    }
}

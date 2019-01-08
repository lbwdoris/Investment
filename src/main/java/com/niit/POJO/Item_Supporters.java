package com.niit.POJO;

import javax.persistence.*;

@Entity
public class Item_Supporters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Item_Supporters_ID;

    @Column
    private Integer Item_ID;

    @Column
    private String Supporter_IDs;

    @Column
    private Double Support_Money;

    public Integer getItem_Supporters_ID() {
        return Item_Supporters_ID;
    }

    public void setItem_Supporters_ID(Integer item_Supporters_ID) {
        Item_Supporters_ID = item_Supporters_ID;
    }

    public Integer getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(Integer item_ID) {
        Item_ID = item_ID;
    }

    public String getSupporter_IDs() {
        return Supporter_IDs;
    }

    public void setSupporter_IDs(String supporter_IDs) {
        Supporter_IDs = supporter_IDs;
    }

    public Double getSupport_Money() {
        return Support_Money;
    }

    public void setSupport_Money(Double support_Money) {
        Support_Money = support_Money;
    }


    public Item_Supporters(Integer item_ID, String supporter_IDs, Double support_Money) {
        Item_ID = item_ID;
        Supporter_IDs = supporter_IDs;
        Support_Money = support_Money;
    }

    public Item_Supporters() {
    }
}


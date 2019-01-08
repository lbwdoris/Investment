package com.niit.POJO;

import javax.persistence.*;

@Entity
public class Country_Currency {
    @Id
    private String Country;
    @Column
    private String Currency_Type;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCurrency_Type() {
        return Currency_Type;
    }

    public void setCurrency_Type(String currency_Type) {
        Currency_Type = currency_Type;
    }

    public Country_Currency() {
    }

    public Country_Currency(String country, String currency_Type) {
        Country = country;
        Currency_Type = currency_Type;
    }
}

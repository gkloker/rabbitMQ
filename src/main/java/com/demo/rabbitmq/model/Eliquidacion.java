package com.demo.rabbitmq.model;

import java.time.LocalDate;

public class Eliquidacion {

    private String cuit;
    private String currency;
    //private LocalDate date;
    private String brand;
    private String commerce;
    private String entity;
    private String subsidiary;
    private String numberAccount;

    public Eliquidacion() {}

    public Eliquidacion(String cuit, String currency, /*LocalDate date,*/ String brand, String commerce, String entity, String subsidiary, String numberAccount) {
        this.cuit = cuit;
        this.currency = currency;
        //this.date = date;
        this.brand = brand;
        this.commerce = commerce;
        this.entity = entity;
        this.subsidiary = subsidiary;
        this.numberAccount = numberAccount;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /*public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }*/

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(String subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    @Override
    public String toString() {
        return "Eliquidacion{" +
                "cuit='" + cuit + '\'' +
                ", currency='" + currency + '\'' +
                //", date=" + date +
                ", brand='" + brand + '\'' +
                ", commerce='" + commerce + '\'' +
                ", entity='" + entity + '\'' +
                ", subsidiary='" + subsidiary + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                '}';
    }
}

package com.lifetech.application.dto;

import javax.persistence.Column;
import java.sql.Timestamp;

public class SubscriptionDTO {
    private String name;
    private Double price;
    private String description;
    private String listofiot ;
    private String listofservice ;
    private Timestamp subscriptiondate ;

    public SubscriptionDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListofiot() {
        return listofiot;
    }

    public void setListofiot(String listofiot) {
        this.listofiot = listofiot;
    }

    public String getListofservice() {
        return listofservice;
    }

    public void setListofservice(String listofservice) {
        this.listofservice = listofservice;
    }

    public Timestamp getSubscriptiondate() {
        return subscriptiondate;
    }

    public void setSubscriptiondate(Timestamp subscriptiondate) {
        this.subscriptiondate = subscriptiondate;
    }
}

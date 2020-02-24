package com.lifetech.application.dto;

import java.sql.Timestamp;

public class SubscriptionResidentDTO {
    private String name;
    private Double price;
    private String description;
    private String listofiot ;
    private String listofservice ;
   private  PersonDTO person ;

    public SubscriptionResidentDTO() {

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

    public PersonDTO getPerson() { return person; }

    public void setPerson(PersonDTO person) { this.person = person; }
}

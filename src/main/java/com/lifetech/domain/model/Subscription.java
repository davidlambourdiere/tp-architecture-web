package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity(name = "subscription")
public class Subscription extends PersistableElement{
    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name="description")
    private String description;

    @Column(name="listofiot")
    private String listofiot;

    @Column(name="listofservice")
    private String listofservice ;

//    @Column(name="subscriptiondate")
//    private Timestamp subscriptiondate ;


    public Subscription(String name, Double price, String description,String listofiot,String listofservice, Timestamp subscriptiondate) {
      
        this.name = name;
        this.price = price;
        this.description = description;
        this.listofiot = listofiot ;
        this.listofservice = listofservice ;
    }
    public Subscription() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListofiot() { return listofiot; }

    public void setListofiot(String listofiot) { this.listofiot = listofiot; }

    public String getListofservice() {
        return listofservice;
    }

    public void setListofservice(String listofservice) {
        this.listofservice = listofservice;
    }

    @Override
    public String toString() {
        return  "Subscription [Nom de la formule : " + name + ", Description :" + description + "Objets connectés de l'abonnement : "+ listofiot+ "Services proposés :"+ listofservice + ", price=" + price
                + "]";

    }
}

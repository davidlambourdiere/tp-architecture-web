package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity(name="subscription_resident")
public class SubscriptionResident extends PersistableElement{
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

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

//    @Column(name="subscriptiondate")
//    private Timestamp subscriptiondate ;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public SubscriptionResident(String name, Double price, String description, String listofiot, String listofservice, Person person) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.listofiot = listofiot;
        this.listofservice = listofservice;
        this.person = person;
    }

    public SubscriptionResident(String name, Double price, String description, String listofiot, String listofservice, Timestamp subscriptiondate) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.listofiot = listofiot ;
        this.listofservice = listofservice ;
    }
    public SubscriptionResident() {

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

    public String getListofiot() { return listofiot; }

    public void setListofiot(String listofiot) { this.listofiot = listofiot; }

    public String getListofservice() {
        return listofservice;
    }

    public void setListofservice(String listofservice) {
        this.listofservice = listofservice;
    }


}

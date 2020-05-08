package com.lifetech.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity(name="extracost")
public class ExtraCost extends PersistableElement{
    @Column(name="extraname")
    private String extraname;

    @Column(name="date")
    private Timestamp date;

    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public ExtraCost(Person person, String extraname, Double price, Timestamp date ) {
        this.extraname = extraname;
        this.date = date;
        this.price = price;
        this.person = person;
    }

    public ExtraCost() {
    }

    public String getExtraname() {
        return extraname;
    }

    public void setExtraname(String extraname) {
        this.extraname = extraname;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

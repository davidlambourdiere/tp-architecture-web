package com.lifetech.application.dto;

import com.lifetech.domain.model.PersistableElement;



import java.sql.Timestamp;

public class ExtraCostDTO extends PersistableElement {

    private String extraname;
    private Timestamp date;
    private Double price;
    private PersonDTO person;

    public ExtraCostDTO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }
}

package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "referencesIOT")
public class ReferencesIOT  extends PersistableElement{

    @Column(name="nameSerie")
    private String numSerie;

    @Column(name="type")
    private String type;

    @Column(name="brand")
    private String brand;

    @Column(name="price")
    private Double price;

    public ReferencesIOT(String numSerie, String type, String brand,Double price) {
        this.numSerie = numSerie;
        this.type = type;
        this.brand = brand;
        this.price = price;
    }

    public ReferencesIOT() {
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "referencesprices")
public class ReferencesPrices extends PersistableElement{

    @Column(name="numSerie")
    private String numSerie;

    @Column(name="type")
    private String type;

    @Column(name="nameService")
    private String nameService;

    @Column(name="descriptionService")
    private String descriptionService;

    @Column(name="price")
    private Double price;

    public ReferencesPrices(String numSerie, String type, String brand, Double price,String nameService,String descriptionService) {
        this.numSerie = numSerie;
        this.type = type;
        this.price = price;
        this.nameService = nameService;
        this.descriptionService = descriptionService;
    }

    public ReferencesPrices() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNameService() { return nameService; }

    public void setNameService(String nameService) { this.nameService = nameService; }

    public String getDescriptionService() { return descriptionService; }

    public void setDescriptionService(String descriptionService) { this.descriptionService = descriptionService; }
}

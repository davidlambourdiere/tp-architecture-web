package com.lifetech.application.dto;

public class ReferencesPricesDTO {
    private String name;
    private String numSerie;
    private String type;
    private String nameService;
    private String descriptionService;
    private String brand ;
    private Double price ;

    public ReferencesPricesDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNameService() { return nameService; }

    public void setNameService(String nameService) { this.nameService = nameService; }

    public String getDescriptionService() { return descriptionService; }

    public void setDescriptionService(String descriptionService) { this.descriptionService = descriptionService; }
}

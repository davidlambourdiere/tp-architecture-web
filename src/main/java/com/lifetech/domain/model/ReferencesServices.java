package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name = "referencesServices")
public class ReferencesServices extends PersistableElement {

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private String price;

    public ReferencesServices(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ReferencesServices() {
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }
}

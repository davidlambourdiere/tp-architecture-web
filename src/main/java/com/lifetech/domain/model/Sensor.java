package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="sensor")
public class Sensor extends PersistableElement{

    @Column(name="name")
    private String name;

    public Sensor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Sensor{" +
                "name='" + name + '\'' +
                '}';
    }
}

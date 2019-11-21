package com.lifetech.application.dto;


public class PersonDTO extends PersistableElementDTO {
    private String name;
    private String lastName;

    public PersonDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

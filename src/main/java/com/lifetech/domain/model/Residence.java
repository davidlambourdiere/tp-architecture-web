package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="residence")
public class Residence extends PersistableElement{
    @Column(name="name")
    private String name;
}

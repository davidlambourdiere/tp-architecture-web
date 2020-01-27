package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name = "personProfile")
public class PersonProfile extends Person {

    @Column(name="age")
    private int age;

    @Column(name="adress")
    private String adress;

    @Column(name="postal_code")
    private int postal_code;

    @Column(name="adress_email")
    private String adress_email;

    @Column(name="tel_number")
    private int tel_number;

    @Column(name="chronic_disease")
    private String chronic_disease;

    @Column(name= "estimated_mobility")
    private int estimated_mobility;

    @Column(name= "smoking")
    private boolean smoking;

    @Column(name = "drinker")
    private boolean drinker;

    @Column(name= "medical_emergencies")
    private boolean medical_emergencies;

    @Column(name = "Hobbies")
    private String Hobbies;

    public PersonProfile(int age, String adress, int postal_code, String adress_email, int tel_number, String chronic_disease, int estimated_mobility, boolean smoking, boolean drinker, boolean medical_emergencies, String hobbies) {
        this.age = age;
        this.adress = adress;
        this.postal_code = postal_code;
        this.adress_email = adress_email;
        this.tel_number = tel_number;
        this.chronic_disease = chronic_disease;
        this.estimated_mobility = estimated_mobility;
        this.smoking = smoking;
        this.drinker = drinker;
        this.medical_emergencies = medical_emergencies;
        Hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "PersonProfile{" +
                "age=" + age +
                ", adress='" + adress + '\'' +
                ", postal_code=" + postal_code +
                ", adress_email='" + adress_email + '\'' +
                ", tel_number=" + tel_number +
                ", chronic_disease='" + chronic_disease + '\'' +
                ", estimated_mobility=" + estimated_mobility +
                ", smoking=" + smoking +
                ", drinker=" + drinker +
                ", medical_emergencies=" + medical_emergencies +
                ", Hobbies='" + Hobbies + '\'' +
                '}';
    }
}

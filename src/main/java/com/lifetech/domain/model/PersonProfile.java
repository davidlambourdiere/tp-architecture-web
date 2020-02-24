package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name = "personprofile")
public class PersonProfile extends PersistableElement {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public String getAdress_email() {
        return adress_email;
    }

    public void setAdress_email(String adress_email) {
        this.adress_email = adress_email;
    }

    public int getTel_number() {
        return tel_number;
    }

    public void setTel_number(int tel_number) {
        this.tel_number = tel_number;
    }

    public String getChronic_disease() {
        return chronic_disease;
    }

    public void setChronic_disease(String chronic_disease) {
        this.chronic_disease = chronic_disease;
    }

    public int getEstimated_mobility() {
        return estimated_mobility;
    }

    public void setEstimated_mobility(int estimated_mobility) {
        this.estimated_mobility = estimated_mobility;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isDrinker() {
        return drinker;
    }

    public void setDrinker(boolean drinker) {
        this.drinker = drinker;
    }

    public boolean isMedical_emergencies() {
        return medical_emergencies;
    }

    public void setMedical_emergencies(boolean medical_emergencies) {
        this.medical_emergencies = medical_emergencies;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Column(name= "smoking")
    private boolean smoking;

    @Column(name = "drinker")
    private boolean drinker;

    @Column(name= "medical_emergencies")
    private boolean medical_emergencies;

    @Column(name = "Hobbies")
    private String hobbies;

    public PersonProfile(){}

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
        this.hobbies = hobbies;
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
                ", Hobbies='" + hobbies + '\'' +
                '}';
    }
}

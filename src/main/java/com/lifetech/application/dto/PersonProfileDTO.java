package com.lifetech.application.dto;

public class PersonProfileDTO extends PersistableElementDTO {


    private String nom;
    private String prenom;
    private int age;
    private String adress;
    private int postal_code;
    private String adress_email;
    private int tel_number;
    private String chronic_disease;
    private int estimated_mobility;
    private boolean smoking;
    private float smoking_time;
    private boolean drinker;
    private boolean medical_emergencies;
    private String hobbies;
    private String profile;

    public PersonProfileDTO(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

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

    public float getSmoking_time() {
        return smoking_time;
    }

    public void setSmoking_time(float smoking_time) {
        this.smoking_time = smoking_time;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}

package com.lifetech.application.dto;

public class PersonProfileDTO extends PersistableElementDTO {

    //private Long id;
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
    private float revenue;
    private String profile;
    private int priority_coef;

     /*@Override
   public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
*/
    public PersonProfileDTO(){}

    public PersonProfileDTO(String nom, String prenom, int age, String adress, int postal_code, String adress_email, int tel_number, String chronic_disease, int estimated_mobility, boolean smoking, float smoking_time, boolean drinker, boolean medical_emergencies, String hobbies, float revenue, String profile, int priority_coef) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adress = adress;
        this.postal_code = postal_code;
        this.adress_email = adress_email;
        this.tel_number = tel_number;
        this.chronic_disease = chronic_disease;
        this.estimated_mobility = estimated_mobility;
        this.smoking = smoking;
        this.smoking_time = smoking_time;
        this.drinker = drinker;
        this.medical_emergencies = medical_emergencies;
        this.hobbies = hobbies;
        this.revenue = revenue;
        this.profile = profile;
        this.priority_coef = priority_coef;
    }

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

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getPriority_coef() {
        return priority_coef;
    }

    public void setPriority_coef(int priority_coef) {
        this.priority_coef = priority_coef;
    }
}

package com.lifetech.application.dto;


public class PersonDTO extends PersistableElementDTO {
    
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String userevaluation;
    private String userrole;
    private String birthdate;
    private String email;
    private String phone;
    private String handicap;
    private String averageincome;
    private String profileType ;

    public PersonDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserevaluation() {
        return userevaluation;
    }

    public void setUserevaluation(String userevaluation) {
        this.userevaluation = userevaluation;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public String getAverageincome() {
        return averageincome;
    }

    public void setAverageincome(String averageincome) {
        this.averageincome = averageincome;
    }

    public String getProfileType() { return profileType; }

    public void setProfileType(String profileType) { this.profileType= profileType; }
}

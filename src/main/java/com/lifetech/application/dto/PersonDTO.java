package com.lifetech.application.dto;


public class PersonDTO extends PersistableElementDTO {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String userevaluation;
    private String userrole;

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
}

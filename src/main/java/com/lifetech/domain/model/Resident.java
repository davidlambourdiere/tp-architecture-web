package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="resident")
public class Resident extends PersistableElement {

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="rank")
    private int rank;

    public Resident() {
    }

    public Resident(String firstName, String lastName, int rank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
}

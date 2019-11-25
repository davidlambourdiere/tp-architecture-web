package com.lifetech.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "person")
public class Person extends PersistableElement{

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="rank")
    private Long userrank;

    @Enumerated(EnumType.STRING)
    private PersonStatus userrole;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<IOT> iots;

    public Person(){}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Long getUserrank() {
        return userrank;
    }

    public void setUserrank(Long userrank) {
        this.userrank = userrank;
    }

    public PersonStatus getUserrole() {
        return userrole;
    }

    public void setUserrole(PersonStatus userrole) {
        this.userrole = userrole;
    }

    public List<IOT> getIots() {
        return iots;
    }

    public void setIots(List<IOT> iots) {
        this.iots = iots;
    }
}

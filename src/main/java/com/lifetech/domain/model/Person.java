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

    @Column(name="deseas")
    private String deseas;

    @Column(name="ismobile")
    private String ismobile;

    @Column(name="userevaluation")
    private Long userevaluation;

    @Enumerated(EnumType.STRING)
    private PersonStatus userrole;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Light> lights;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Shutter> shutters;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Heater> heaters;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Clock> clocks;

    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private Strap strap;

    public Person(){}

    public Person(String firstName, String lastName, String deseas, String ismobile, Long userevaluation, PersonStatus userrole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deseas = deseas;
        this.ismobile = ismobile;
        this.userevaluation = userevaluation;
        this.userrole = userrole;
    }

    public String getDeseas() {
        return deseas;
    }

    public void setDeseas(String deseas) {
        this.deseas = deseas;
    }

    public String getIsmobile() {
        return ismobile;
    }

    public void setIsmobile(String ismobile) {
        this.ismobile = ismobile;
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

    public Long getUserevaluation() {
        return userevaluation;
    }

    public void setUserevaluation(Long userevaluation) {
        this.userevaluation = userevaluation;
    }

    public PersonStatus getUserrole() {
        return userrole;
    }

    public void setUserrole(PersonStatus userrole) {
        this.userrole = userrole;
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public List<Shutter> getShutters() {
        return shutters;
    }

    public void setShutters(List<Shutter> shutters) {
        this.shutters = shutters;
    }

    public Strap getStrap() {
        return strap;
    }

    public void setStrap(Strap strap) {
        this.strap = strap;
    }

    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public List<Clock> getClocks() {
        return clocks;
    }

    public void setClocks(List<Clock> clocks) {
        this.clocks = clocks;
    }
}

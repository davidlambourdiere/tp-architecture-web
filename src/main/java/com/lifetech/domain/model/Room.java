package com.lifetech.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "room")
public class Room extends PersistableElement {

    @Column (name="num")
    private String num;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Light> lights;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Shutter> shutters;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Heater> heaters;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Clock> clocks;

    public Room() {}

    public Room(String num, List<Light> lights, List<Shutter> shutters, List<Heater> heaters, List<Clock> clocks) {
        this.num = num;
        this.lights = lights;
        this.shutters = shutters;
        this.heaters = heaters;
        this.clocks = clocks;
    }

    public String getNum() { return num; }

    public List<Light> getLights() { return lights; }

    public List<Shutter> getShutters() { return shutters; }

    public List<Heater> getHeaters() { return heaters; }

    public List<Clock> getClocks() { return clocks; }

    public void setNum(String num) { this.num = num; }

    public void setLights(List<Light> lights) { this.lights = lights; }

    public void setShutters(List<Shutter> shutters) { this.shutters = shutters; }

    public void setHeaters(List<Heater> heaters) { this.heaters = heaters; }

    public void setClocks(List<Clock> clocks) { this.clocks = clocks; }
}

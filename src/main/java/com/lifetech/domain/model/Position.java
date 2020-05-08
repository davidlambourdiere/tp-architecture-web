package com.lifetech.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "position")
public class Position extends PersistableElement {

    @Column(name = "date")
    private Date date;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @ManyToOne(cascade = CascadeType.ALL)
    private Strap strap;

    public Position() {}

    public Position(Date date, Double latitude, Double longitude) {
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Strap getStrap() {
        return strap;
    }

    public void setStrap(Strap strap) {
        this.strap = strap;
    }

    @Override
    public String toString() {
        return "Position{" +
                "date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", strap=" + strap +
                '}';
    }
}

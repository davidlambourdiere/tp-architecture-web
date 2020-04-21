package com.lifetech.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "position")
@IdClass(PositionId.class)
public class Position extends PersistableElement {

    @Column(name = "date")
    private Date date;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longitude")
    private float longitude;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Strap strap;

    public Position() {}

    public Position(Date date, float latitude, float longitude) {
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
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
                ", optlock=" + optlock +
                '}';
    }
}

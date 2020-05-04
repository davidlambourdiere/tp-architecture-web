package com.lifetech.application.dto;

import java.util.Date;

public class PositionDTO extends PersistableElementDTO {
    private Date date;
    private float latitude;
    private float longitude;
    private StrapDTO strap;

    public PositionDTO() {
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

    public StrapDTO getStrap() {
        return strap;
    }

    public void setStrap(StrapDTO strap) {
        this.strap = strap;
    }

    @Override
    public String toString() {
        return "PositionDTO{" +
                "date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", strap=" + strap +
                ", optlock=" + optlock +
                '}';
    }
}

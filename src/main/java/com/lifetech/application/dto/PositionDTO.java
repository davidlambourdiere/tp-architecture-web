package com.lifetech.application.dto;

import java.util.Date;

public class PositionDTO extends PersistableElementDTO {
    private Date date;
    private Double latitude;
    private Double longitude;
    private StrapDTO strap;

    public PositionDTO() {
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

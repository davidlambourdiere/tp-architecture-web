package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name="lighthistoric")
public class LightHistoric extends PersistableElement{

    @Column(name="startdate")
    private Date startDate;

    @Column(name="endingdate")
    private Date endingDate;

    @Column(name="state")
    private String state;

    @Column(name="lightid")
    private Long lightId;

    @Column(name="color")
    private String color;

    @Column(name = "percentage")
    private String percentage;

    public LightHistoric() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getLightId() {
        return lightId;
    }

    public void setLightId(Long lightId) {
        this.lightId = lightId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}

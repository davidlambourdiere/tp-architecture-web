package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "straphistoric")
public class StrapHistoric extends PersistableElement {
    @Column(name="startdate")
    private Date startDate;

    @Column(name="endingdate")
    private Date endingDate;

    @Column(name="state")
    private String state;

    @Column(name="strapId")
    private Long strapId;

    public StrapHistoric() {
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

    public Long getStrapId() {
        return strapId;
    }

    public void setStrapId(Long strapId) {
        this.strapId = strapId;
    }
}

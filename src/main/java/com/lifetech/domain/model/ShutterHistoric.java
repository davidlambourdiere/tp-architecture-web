package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "shutterhistoric")
public class ShutterHistoric extends PersistableElement {
    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "endingdate")
    private Date endingDate;

    @Column(name = "state")
    private String state;

    @Column(name = "shutterId")
    private Long shutterId;

    @Column(name = "percentage")
    private String percentage;

    public ShutterHistoric() {
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

    public Long getShutterId() {
        return shutterId;
    }

    public void setShutterId(Long shutterId) {
        this.shutterId = shutterId;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}

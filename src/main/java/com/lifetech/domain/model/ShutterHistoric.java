package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity(name = "shutterhistoric")
public class ShutterHistoric extends PersistableElement {
    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "endingdate")
    private Date endingDate;

    @Enumerated(EnumType.STRING)
    private StateEnum state;

    @Enumerated(EnumType.STRING)
    private StatusEnum breakdownstatus;

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

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
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

    public StatusEnum getBreakdownstatus() {
        return breakdownstatus;
    }

    public void setBreakdownstatus(StatusEnum breakdownstatus) {
        this.breakdownstatus = breakdownstatus;
    }
}

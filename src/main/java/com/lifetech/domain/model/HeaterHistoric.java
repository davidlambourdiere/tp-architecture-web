package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity(name="heaterhistoric")
public class HeaterHistoric extends PersistableElement{

    @Column(name="startdate")
    private Date startdate;

    @Column(name="endingdate")
    private Date endingdate;

    @Column(name="temperature")
    private String temperature;

    @Enumerated(EnumType.STRING)
    private StatusEnum breakdownstatus;

    @Enumerated(EnumType.STRING)
    private StateEnum state;

    @Column(name="heaterid")
    private Long heaterId;

    public HeaterHistoric() {
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndingdate() {
        return endingdate;
    }

    public void setEndingdate(Date endingdate) {
        this.endingdate = endingdate;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Long getHeaterId() {
        return heaterId;
    }

    public void setHeaterId(Long heaterId) {
        this.heaterId = heaterId;
    }

    public StatusEnum getBreakdownstatus() {
        return breakdownstatus;
    }

    public void setBreakdownstatus(StatusEnum breakdownstatus) {
        this.breakdownstatus = breakdownstatus;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}

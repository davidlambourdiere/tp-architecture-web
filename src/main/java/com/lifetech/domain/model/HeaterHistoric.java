package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity(name="heaterhistoric")
public class HeaterHistoric extends PersistableElement{

    @Column(name="startdate")
    private Date startDate;

    @Column(name="endingdate")
    private Date endingDate;

    @Enumerated(EnumType.STRING)
    private StatusEnum breakdownstatus;

    @Enumerated(EnumType.STRING)
    private StateEnum state;

    @Column(name="heaterid")
    private Long heaterId;

    public HeaterHistoric() {
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
}

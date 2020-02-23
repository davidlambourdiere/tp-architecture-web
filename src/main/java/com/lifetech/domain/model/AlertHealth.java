package com.lifetech.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity(name="alerthealth")
public class AlertHealth extends PersistableElement{
    @Column(name="message")
    private String message;

    @Column(name="startdate")
    private Timestamp startdate;

    @Column(name="criticity")
    private String criticity;

    @Column(name="strapid")
    private Long strap;

    public AlertHealth(String message, Timestamp startdate, String criticity, Long strap) {
        this.message = message;
        this.startdate = startdate;
        this.criticity = criticity;
        this.strap = strap;
    }

    public AlertHealth(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public String getCriticity() {
        return criticity;
    }

    public void setCriticity(String criticity) {
        this.criticity = criticity;
    }

    public Long getStrap() {
        return strap;
    }

    public void setStrap(Long strap) {
        this.strap = strap;
    }

    @Override
    public String toString() {
        return "AlertHealth{" +
                "message='" + message + '\'' +
                ", startdate=" + startdate +
                ", criticity='" + criticity + '\'' +
                ", strap=" + strap +
                '}';
    }
}

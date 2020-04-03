package com.lifetech.application.dto;

import java.sql.Timestamp;

public class AlertHealthDTO {
   private String message;

    private Timestamp startdate;

    private Timestamp enddate;

    private String criticity;

    private String status;

    private StrapDTO strap;

    private PersonDTO doctor;

    public AlertHealthDTO() {
    }

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

    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    public String getCriticity() {
        return criticity;
    }

    public void setCriticity(String criticity) {
        this.criticity = criticity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StrapDTO getStrap() {
        return strap;
    }

    public void setStrap(StrapDTO strap) {
        this.strap = strap;
    }

    public PersonDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(PersonDTO doctor) {
        this.doctor = doctor;
    }
}

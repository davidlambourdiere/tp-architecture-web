package com.lifetech.application.dto;

import java.sql.Timestamp;

public class AlertHealthDTO {
   private String message;

    private Timestamp startdate;

    private String criticity;

    private StrapDTO strap;

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

    public String getCriticity() {
        return criticity;
    }

    public void setCriticity(String criticity) {
        this.criticity = criticity;
    }

    public StrapDTO getStrap() {
        return strap;
    }

    public void setStrap(StrapDTO strap) {
        this.strap = strap;
    }

    @Override
    public String toString() {
        return "AlertHealthDTO{" +
                "message='" + message + '\'' +
                ", startdate=" + startdate +
                ", criticity='" + criticity + '\'' +
                ", strap=" + strap +
                '}';
    }
}

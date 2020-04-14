package com.lifetech.application.dto;

import java.sql.Timestamp;

public class HealthHistoricDTO extends PersistableElementDTO{

    private String hearthrate;

    private String systolic;

    private String diastolic;

    private String sugarlevel;

    private String stepcounter;

    private Timestamp startdate;

    private String strap;



    public String getHearthrate() {
        return hearthrate;
    }

    public void setHearthrate(String hearthrate) {
        this.hearthrate = hearthrate;
    }

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public String getSugarlevel() {
        return sugarlevel;
    }

    public void setSugarlevel(String sugarlevel) {
        this.sugarlevel = sugarlevel;
    }

    public String getStepcounter() {
        return stepcounter;
    }

    public void setStepcounter(String stepcounter) {
        this.stepcounter = stepcounter;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public String getStrap() {
        return strap;
    }

    public void setStrap(String strap) {
        this.strap = strap;
    }
}

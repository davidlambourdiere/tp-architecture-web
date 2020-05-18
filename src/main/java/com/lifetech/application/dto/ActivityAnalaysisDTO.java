package com.lifetech.application.dto;

public class ActivityAnalaysisDTO {
    private String residenceid;
    private String personid;
    private String period;
    private String startdate;
    private String enddate;
    private String heaterbreakdownrate;
    private String clockbreakdownrate;
    private String lightbreakdownrate;
    private String strapbreakdownrate;
    private String nheater;
    private String nclock;
    private String nlight;
    private String nstrap;

    public ActivityAnalaysisDTO() {
    }

    public String getResidenceid() {
        return residenceid;
    }

    public void setResidenceid(String residenceid) {
        this.residenceid = residenceid;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getHeaterbreakdownrate() {
        return heaterbreakdownrate;
    }

    public void setHeaterbreakdownrate(String heaterbreakdownrate) {
        this.heaterbreakdownrate = heaterbreakdownrate;
    }

    public String getClockbreakdownrate() {
        return clockbreakdownrate;
    }

    public void setClockbreakdownrate(String clockbreakdownrate) {
        this.clockbreakdownrate = clockbreakdownrate;
    }

    public String getLightbreakdownrate() {
        return lightbreakdownrate;
    }

    public void setLightbreakdownrate(String lightbreakdownrate) {
        this.lightbreakdownrate = lightbreakdownrate;
    }

    public String getStrapbreakdownrate() {
        return strapbreakdownrate;
    }

    public void setStrapbreakdownrate(String strapbreakdownrate) {
        this.strapbreakdownrate = strapbreakdownrate;
    }

    public String getNheater() {
        return nheater;
    }

    public void setNheater(String nheater) {
        this.nheater = nheater;
    }

    public String getNclock() {
        return nclock;
    }

    public void setNclock(String nclock) {
        this.nclock = nclock;
    }

    public String getNlight() {
        return nlight;
    }

    public void setNlight(String nlight) {
        this.nlight = nlight;
    }

    public String getNstrap() {
        return nstrap;
    }

    public void setNstrap(String nstrap) {
        this.nstrap = nstrap;
    }

    @Override
    public String toString() {
        return "ActivityAnalaysisDTO{" +
                "residenceid='" + residenceid + '\'' +
                ", personid='" + personid + '\'' +
                ", period='" + period + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", heaterbreakdownrate='" + heaterbreakdownrate + '\'' +
                ", clockbreakdownrate='" + clockbreakdownrate + '\'' +
                ", lightbreakdownrate='" + lightbreakdownrate + '\'' +
                ", strapbreakdownrate='" + strapbreakdownrate + '\'' +
                ", nheater='" + nheater + '\'' +
                ", nclock='" + nclock + '\'' +
                ", nlight='" + nlight + '\'' +
                ", nstrap='" + nstrap + '\'' +
                '}';
    }
}

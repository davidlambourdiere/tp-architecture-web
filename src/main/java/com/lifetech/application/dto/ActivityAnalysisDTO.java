package com.lifetech.application.dto;

import java.util.Objects;

public class ActivityAnalysisDTO {
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

    public ActivityAnalysisDTO() {
    }

    public ActivityAnalysisDTO(String residenceid, String personid, String period, String startdate, String enddate, String heaterbreakdownrate, String clockbreakdownrate, String lightbreakdownrate, String strapbreakdownrate, String nheater, String nclock, String nlight, String nstrap) {
        this.residenceid = residenceid;
        this.personid = personid;
        this.period = period;
        this.startdate = startdate;
        this.enddate = enddate;
        this.heaterbreakdownrate = heaterbreakdownrate;
        this.clockbreakdownrate = clockbreakdownrate;
        this.lightbreakdownrate = lightbreakdownrate;
        this.strapbreakdownrate = strapbreakdownrate;
        this.nheater = nheater;
        this.nclock = nclock;
        this.nlight = nlight;
        this.nstrap = nstrap;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityAnalysisDTO that = (ActivityAnalysisDTO) o;
        return Objects.equals(residenceid, that.residenceid) &&
                Objects.equals(personid, that.personid) &&
                Objects.equals(period, that.period) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(enddate, that.enddate) &&
                Objects.equals(heaterbreakdownrate, that.heaterbreakdownrate) &&
                Objects.equals(clockbreakdownrate, that.clockbreakdownrate) &&
                Objects.equals(lightbreakdownrate, that.lightbreakdownrate) &&
                Objects.equals(strapbreakdownrate, that.strapbreakdownrate) &&
                Objects.equals(nheater, that.nheater) &&
                Objects.equals(nclock, that.nclock) &&
                Objects.equals(nlight, that.nlight) &&
                Objects.equals(nstrap, that.nstrap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residenceid, personid, period, startdate, enddate, heaterbreakdownrate, clockbreakdownrate, lightbreakdownrate, strapbreakdownrate, nheater, nclock, nlight, nstrap);
    }
}

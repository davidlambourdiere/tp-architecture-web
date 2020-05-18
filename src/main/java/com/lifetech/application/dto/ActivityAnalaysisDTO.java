package com.lifetech.application.dto;

public class ActivityAnalaysisDTO {
    private String residenceid;
    private String personid;
    private String period;
    private String startdate;
    private String enddate;
    private String heaterbreakdownrate;
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

    @Override
    public String toString() {
        return "ActivityAnalaysisDTO{" +
                "residenceid='" + residenceid + '\'' +
                ", personid='" + personid + '\'' +
                ", period='" + period + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", heaterbreakdownrate='" + heaterbreakdownrate + '\'' +
                '}';
    }
}

package com.lifetech.application.dto;

public class ShutterHistoricDTO extends PersistableElementDTO {
    private String startdate;
    private String endingdate;
    private String state;
    private String breakdownstatus;

    public ShutterHistoricDTO() {
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEndingdate() {
        return endingdate;
    }

    public void setEndingdate(String endingdate) {
        this.endingdate = endingdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBreakdownstatus() {
        return breakdownstatus;
    }

    public void setBreakdownstatus(String breakdownstatus) {
        this.breakdownstatus = breakdownstatus;
    }
}

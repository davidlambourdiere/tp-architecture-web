package com.lifetech.application.dto;

public class HeaterHistoricDTO extends PersistableElementDTO {
    private String startdate;
    private String endingdate;
    private String state;
    private String breakdownstatus;
    private String temperature;
    private boolean temperaturetohot;

    public HeaterHistoricDTO() {
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public boolean isTemperaturetohot() {
        return temperaturetohot;
    }

    public void setTemperaturetohot(boolean temperaturetohot) {
        this.temperaturetohot = temperaturetohot;
    }
}

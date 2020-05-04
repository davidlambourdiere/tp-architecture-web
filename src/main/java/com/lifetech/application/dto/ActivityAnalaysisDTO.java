package com.lifetech.application.dto;

public class ActivityAnalaysisDTO {
    private String personName;
    private String residenceName;
    private Long nClock;
    private Long nHeather;
    private Long nLight;
    private Long nAlert;
    private Long nBreakdown;
    private Double heaterBreakdownRate;

    public ActivityAnalaysisDTO() {
    }

    public Long getnClock() {
        return nClock;
    }

    public void setnClock(Long nClock) {
        this.nClock = nClock;
    }

    public Long getnHeather() {
        return nHeather;
    }

    public void setnHeather(Long nHeather) {
        this.nHeather = nHeather;
    }

    public Long getnLight() {
        return nLight;
    }

    public void setnLight(Long nLight) {
        this.nLight = nLight;
    }
    public Long getnAlert() {
        return nAlert;
    }

    public void setnAlert(Long nAlert) {
        this.nAlert = nAlert;
    }

    public Long getnBreakdown() {
        return nBreakdown;
    }

    public void setnBreakdown(Long nBreakdown) {
        this.nBreakdown = nBreakdown;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    public Double getHeaterBreakdownRate() {
        return heaterBreakdownRate;
    }

    public void setHeaterBreakdownRate(Double heaterBreakdownRate) {
        this.heaterBreakdownRate = heaterBreakdownRate;
    }
}

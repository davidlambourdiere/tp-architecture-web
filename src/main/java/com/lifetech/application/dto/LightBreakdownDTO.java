package com.lifetech.application.dto;

import com.lifetech.domain.model.IOT;
import com.lifetech.domain.model.Light;

public class LightBreakdownDTO extends PersistableElementDTO{
    private String numlightbreakdown;
    private String startdatelightbreakdown;
    private String enddatelightbreakdown;
    private String suspectlightbreakdown;
    private String stoplightbreakdown;
    private String messagelightbreakdown;
    private Light iotlightbreakdown;

    public LightBreakdownDTO() {
    }

    public String getNumlightbreakdown() {
        return numlightbreakdown;
    }

    public void setNumlightbreakdown(String numlightbreakdown) {
        this.numlightbreakdown = numlightbreakdown;
    }

    public String getStartdatelightbreakdown() {
        return startdatelightbreakdown;
    }

    public void setStartdatelightbreakdown(String startdatelightbreakdown) {
        this.startdatelightbreakdown = startdatelightbreakdown;
    }

    public String getEnddatelightbreakdown() {
        return enddatelightbreakdown;
    }

    public void setEnddatelightbreakdown(String enddatelightbreakdown) {
        this.enddatelightbreakdown = enddatelightbreakdown;
    }

    public String getSuspectlightbreakdown() {
        return suspectlightbreakdown;
    }

    public void setSuspectlightbreakdown(String suspectlightbreakdown) {
        this.suspectlightbreakdown = suspectlightbreakdown;
    }

    public String getStoplightbreakdown() {
        return stoplightbreakdown;
    }

    public void setStoplightbreakdown(String stoplightbreakdown) {
        this.stoplightbreakdown = stoplightbreakdown;
    }

    public String getMessagelightbreakdown() {
        return messagelightbreakdown;
    }

    public void setMessagelightbreakdown(String messagelightbreakdown) {
        this.messagelightbreakdown = messagelightbreakdown;
    }

    public Light getIotlightbreakdown() {
        return iotlightbreakdown;
    }

    public void setIotlightbreakdown(Light iotlightbreakdown) {
        this.iotlightbreakdown = iotlightbreakdown;
    }
}

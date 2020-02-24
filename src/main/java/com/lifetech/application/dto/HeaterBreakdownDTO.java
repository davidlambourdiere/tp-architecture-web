package com.lifetech.application.dto;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.IOT;

public class HeaterBreakdownDTO extends PersistableElementDTO{
    private String numheaterbreakdown;
    private String startdateheaterbreakdown;
    private String enddateheaterbreakdown;
    private String suspectheaterbreakdown;
    private String stopheaterbreakdown;
    private String messageheaterbreakdown;
    private Heater iotheaterbreakdown;

    public HeaterBreakdownDTO() {
    }

    public String getNumheaterbreakdown() {
        return numheaterbreakdown;
    }

    public void setNumheaterbreakdown(String numheaterbreakdown) {
        this.numheaterbreakdown = numheaterbreakdown;
    }

    public String getStartdateheaterbreakdown() {
        return startdateheaterbreakdown;
    }

    public void setStartdateheaterbreakdown(String startdateheaterbreakdown) {
        this.startdateheaterbreakdown = startdateheaterbreakdown;
    }

    public String getEnddateheaterbreakdown() {
        return enddateheaterbreakdown;
    }

    public void setEnddateheaterbreakdown(String enddateheaterbreakdown) {
        this.enddateheaterbreakdown = enddateheaterbreakdown;
    }

    public String getSuspectheaterbreakdown() {
        return suspectheaterbreakdown;
    }

    public void setSuspectheaterbreakdown(String suspectheaterbreakdown) {
        this.suspectheaterbreakdown = suspectheaterbreakdown;
    }

    public String getStopheaterbreakdown() {
        return stopheaterbreakdown;
    }

    public void setStopheaterbreakdown(String stopheaterbreakdown) {
        this.stopheaterbreakdown = stopheaterbreakdown;
    }

    public String getMessageheaterbreakdown() {
        return messageheaterbreakdown;
    }

    public void setMessageheaterbreakdown(String messageheaterbreakdown) {
        this.messageheaterbreakdown = messageheaterbreakdown;
    }

    public Heater getIotheaterbreakdown() {
        return iotheaterbreakdown;
    }

    public void setIotheaterbreakdown(Heater iotheaterbreakdown) {
        this.iotheaterbreakdown = iotheaterbreakdown;
    }
}

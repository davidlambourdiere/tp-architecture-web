package com.lifetech.application.dto;

import com.lifetech.domain.model.IOT;
import com.lifetech.domain.model.Strap;

public class StrapBreakdownDTO extends PersistableElementDTO{
    private String numstrapbreakdown;
    private String startdatestrapbreakdown;
    private String enddatestrapbreakdown;
    private String suspectstrapbreakdown;
    private String stopstrapbreakdown;
    private String messagestrapbreakdown;
    private Strap iotstrapbreakdown;

    public StrapBreakdownDTO() {
    }

    public String getNumstrapbreakdown() {
        return numstrapbreakdown;
    }

    public void setNumstrapbreakdown(String numstrapbreakdown) {
        this.numstrapbreakdown = numstrapbreakdown;
    }

    public String getStartdatestrapbreakdown() {
        return startdatestrapbreakdown;
    }

    public void setStartdatestrapbreakdown(String startdatestrapbreakdown) {
        this.startdatestrapbreakdown = startdatestrapbreakdown;
    }

    public String getEnddatestrapbreakdown() {
        return enddatestrapbreakdown;
    }

    public void setEnddatestrapbreakdown(String enddatestrapbreakdown) {
        this.enddatestrapbreakdown = enddatestrapbreakdown;
    }

    public String getSuspectstrapbreakdown() {
        return suspectstrapbreakdown;
    }

    public void setSuspectstrapbreakdown(String suspectstrapbreakdown) {
        this.suspectstrapbreakdown = suspectstrapbreakdown;
    }

    public String getStopstrapbreakdown() {
        return stopstrapbreakdown;
    }

    public void setStopstrapbreakdown(String stopstrapbreakdown) {
        this.stopstrapbreakdown = stopstrapbreakdown;
    }

    public String getMessagestrapbreakdown() {
        return messagestrapbreakdown;
    }

    public void setMessagestrapbreakdown(String messagestrapbreakdown) {
        this.messagestrapbreakdown = messagestrapbreakdown;
    }

    public Strap getIotstrapbreakdown() {
        return iotstrapbreakdown;
    }

    public void setIotstrapbreakdown(Strap iotstrapbreakdown) {
        this.iotstrapbreakdown = iotstrapbreakdown;
    }
}

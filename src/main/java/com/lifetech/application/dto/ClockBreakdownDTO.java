package com.lifetech.application.dto;

import com.lifetech.domain.model.Clock;

public class ClockBreakdownDTO extends PersistableElementDTO{
    private String numclockbreakdown;
    private String startdateclockbreakdown;
    private String enddateclockbreakdown;
    private String suspectclockbreakdown;
    private String stopclockbreakdown;
    private String messageclockbreakdown;
    private Clock iotclockbreakdown;

    public ClockBreakdownDTO() {
    }

    public String getNumclockbreakdown() {
        return numclockbreakdown;
    }

    public void setNumclockbreakdown(String numclockbreakdown) {
        this.numclockbreakdown = numclockbreakdown;
    }

    public String getStartdateclockbreakdown() {
        return startdateclockbreakdown;
    }

    public void setStartdateclockbreakdown(String startdateclockbreakdown) {
        this.startdateclockbreakdown = startdateclockbreakdown;
    }

    public String getEnddateclockbreakdown() {
        return enddateclockbreakdown;
    }

    public void setEnddateclockbreakdown(String enddateclockbreakdown) {
        this.enddateclockbreakdown = enddateclockbreakdown;
    }

    public String getSuspectclockbreakdown() {
        return suspectclockbreakdown;
    }

    public void setSuspectclockbreakdown(String suspectclockbreakdown) {
        this.suspectclockbreakdown = suspectclockbreakdown;
    }

    public String getStopclockbreakdown() {
        return stopclockbreakdown;
    }

    public void setStopclockbreakdown(String stopclockbreakdown) {
        this.stopclockbreakdown = stopclockbreakdown;
    }

    public String getMessageclockbreakdown() {
        return messageclockbreakdown;
    }

    public void setMessageclockbreakdown(String messageclockbreakdown) {
        this.messageclockbreakdown = messageclockbreakdown;
    }

    public Clock getIotclockbreakdown() {
        return iotclockbreakdown;
    }

    public void setIotclockbreakdown(Clock iotclockbreakdown) {
        this.iotclockbreakdown = iotclockbreakdown;
    }
}

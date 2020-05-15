package com.lifetech.application.dto;

import java.sql.Timestamp;

public class LightDTO extends PersistableElementDTO {
    private String breakdownstatus;
    private String state;
    private Timestamp startdate;
    private String minvalueref;
    private String ipadress;
    private String suspect;
    private String maxvalueref;
    private Timestamp activityduration;
    private String color;
    private String percentage;
    private PersonDTO person;
    private Double price ;
    private RoomDTO room;

    public LightDTO() {
    }

    public String getBreakdownstatus() {
        return breakdownstatus;
    }

    public void setBreakdownstatus(String breakdownstatus) {
        this.breakdownstatus = breakdownstatus;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public String getMinvalueref() {
        return minvalueref;
    }

    public void setMinvalueref(String minvalueref) {
        this.minvalueref = minvalueref;
    }

    public String getMaxvalueref() {
        return maxvalueref;
    }

    public void setMaxvalueref(String maxvalueref) {
        this.maxvalueref = maxvalueref;
    }

    public Timestamp getActivityduration() {
        return activityduration;
    }

    public void setActivityduration(Timestamp activityduration) {
        this.activityduration = activityduration;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public String getSuspect() {
        return suspect;
    }

    public void setSuspect(String suspect) {
        this.suspect = suspect;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public RoomDTO getRoom() { return room; }

    @Override
    public String toString() {
        return "LightDTO{" +
                "breakdownstatus='" + breakdownstatus + '\'' +
                ", state='" + state + '\'' +
                ", startdate=" + startdate +
                ", minvalueref='" + minvalueref + '\'' +
                ", ipadress='" + ipadress + '\'' +
                ", suspect='" + suspect + '\'' +
                ", maxvalueref='" + maxvalueref + '\'' +
                ", activityduration=" + activityduration +
                ", color='" + color + '\'' +
                ", percentage='" + percentage + '\'' +
                ", person=" + person +
                ", price=" + price +
                ", room=" + room +
                '}';
    }

    public void setRoom(RoomDTO room) { this.room = room; }
}

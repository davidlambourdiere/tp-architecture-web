package com.lifetech.application.dto;

import java.sql.Timestamp;

public class StrapDTO extends PersistableElementDTO{

    private String status;
    private String state;
    private Timestamp startdate;
    private String minvalueref;
    private String suspect;
    private String maxvalueref;
    private String ipadress;
    private Timestamp activityduration;
    private String minsysto;
    private String maxsysto;
    private String maxdiasto;
    private String minglyc;
    private String maxglyc;
    private String minsteps;
    private PersonDTO person;
    private RoomDTO room;
    private Double price ;

    public StrapDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getSuspect() {
        return suspect;
    }

    public void setSuspect(String suspect) {
        this.suspect = suspect;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress;
    }

    public String getMinsysto() {
        return minsysto;
    }

    public void setMinsysto(String minsysto) {
        this.minsysto = minsysto;
    }

    public String getMaxsysto() {
        return maxsysto;
    }

    public void setMaxsysto(String maxsysto) {
        this.maxsysto = maxsysto;
    }

    public String getMaxdiasto() {
        return maxdiasto;
    }

    public void setMaxdiasto(String maxdiasto) {
        this.maxdiasto = maxdiasto;
    }

    public String getMinglyc() {
        return minglyc;
    }

    public void setMinglyc(String minglyc) {
        this.minglyc = minglyc;
    }

    public String getMaxglyc() {
        return maxglyc;
    }

    public void setMaxglyc(String maxglyc) {
        this.maxglyc = maxglyc;
    }

    public String getMinsteps() {
        return minsteps;
    }

    public void setMinsteps(String minsteps) {
        this.minsteps = minsteps;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}

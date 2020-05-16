package com.lifetech.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity(name="clock")
public class Clock extends IOT {
    @Column(name = "minvalueref")
    private String minvalueref;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(cascade =  CascadeType.ALL)
    private Room room;

    public Clock(Double price, StatusEnum breakdownstatus, StateEnum state, String ipadress, Timestamp startdate, String minvalueref, String maxvalueref, String suspect, Timestamp activityduration, Timestamp time, Person person, Room room) {
        super(price, breakdownstatus, state, ipadress, startdate, minvalueref, maxvalueref, suspect, activityduration);
        this.person = person;
        this.room = room;
        this.minvalueref = minvalueref;
    }

    public Clock() {
    }

//    public Timestamp getTime() {
//        return time;
//    }
//
//    public void setTime(Timestamp time) {
//        this.time = time;
//    }
    @Override
    public String getMinvalueref() {
    return minvalueref;
}

    @Override
    public void setMinvalueref(String minvalueref) {
        this.minvalueref = minvalueref;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room getRoom() { return room; }

    public void setRoom(Room room) { this.room = room; }

    @Override
    public String toString() {
        return "Clock{" +
                "minvalueref='" + minvalueref + '\'' +
                ", person=" + person +
                ", room=" + room +
                '}';
    }
}

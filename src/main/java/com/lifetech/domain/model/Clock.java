package com.lifetech.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity(name="clock")
public class Clock extends IOT {

    @Column(name="time")
    private Timestamp time;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(cascade =  CascadeType.ALL)
    private Room room;

    public Clock(String status, String state, String ipadress, Timestamp startdate, String minvalueref, String maxvalueref, String suspect, Timestamp activityduration, Timestamp time, Person person, Room room) {
        super(status, state, ipadress, startdate, minvalueref, maxvalueref, suspect, activityduration);
        this.time = time;
        this.person = person;
        this.room = room;
    }

    public Clock() {
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room getRoom() { return room; }

    public void setRoom(Room room) { this.room = room; }
}

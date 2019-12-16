package com.lifetech.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity(name="heater")
public class Heater  extends IOT{

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;

    public Heater(Double price, String status, String state, String ipadress, Timestamp startdate, String minvalueref, String maxvalueref, String suspect, Timestamp activityduration, Person person, Room room) {
        super(price, status, state, ipadress, startdate, minvalueref, maxvalueref, suspect, activityduration);
        this.person = person;
        this.room = room;
    }

    public Heater() {
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

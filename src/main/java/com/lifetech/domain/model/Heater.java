package com.lifetech.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity(name="heater")
public class Heater  extends IOT{

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    public Heater(String status, String state, Timestamp startdate, String minvalueref, String maxvalueref, Timestamp activityduration, Person person) {
        super(status, state, startdate, minvalueref, maxvalueref, activityduration);
        this.person = person;
    }

    public Heater() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}

package com.lifetech.domain.model;

import javax.persistence.*;

@Entity(name="clockbreakdown")
public class ClockBreakdown extends PersistableElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name="numclockbreakdown")
    private String numclockbreakdown;

    @Column(name="startdateclockbreakdown")
    private String startdateclockbreakdown;

    @Column(name="enddateclockbreakdown")
    private String enddateclockbreakdown;

    @Column(name="suspectclockbreakdown")
    private String suspectclockbreakdown;

    @Column(name="stopclockbreakdown")
    private String stopclockbreakdown;

    @Column(name="messageclockbreakdown")
    private String messageclockbreakdown;

    @ManyToOne(cascade = CascadeType.ALL)
    private Clock iotclockbreakdown;

    public ClockBreakdown() {
    }

    public ClockBreakdown(String numclockbreakdown, String startdateclockbreakdown, String enddateclockbreakdown, String suspectclockbreakdown, String stopclockbreakdown, String messageclockbreakdown, Clock iotclockbreakdown) {
        this.numclockbreakdown = numclockbreakdown;
        this.startdateclockbreakdown = startdateclockbreakdown;
        this.enddateclockbreakdown = enddateclockbreakdown;
        this.suspectclockbreakdown = suspectclockbreakdown;
        this.stopclockbreakdown = stopclockbreakdown;
        this.messageclockbreakdown = messageclockbreakdown;
        this.iotclockbreakdown = iotclockbreakdown;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

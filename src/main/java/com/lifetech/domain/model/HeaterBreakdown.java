package com.lifetech.domain.model;

import javax.persistence.*;

@Entity(name="heaterbreakdown")
public class HeaterBreakdown extends PersistableElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name="numheaterbreakdown")
    private String numheaterbreakdown;

    @Column(name="startdateheaterbreakdown")
    private String startdateheaterbreakdown;

    @Column(name="enddateheaterbreakdown")
    private String enddatebreakdown;

    @Column(name="suspectheaterbreakdown")
    private String suspectheaterbreakdown;

    @Column(name="stopheaterbreakdown")
    private String stopheaterbreakdown;

    @Column(name="messageheaterbreakdown")
    private String messageheaterbreakdown;

    @ManyToOne(cascade = CascadeType.ALL)
    private Heater iotheaterbreakdown;

    public HeaterBreakdown() {
    }

    public HeaterBreakdown(String numheaterbreakdown, String startdateheaterbreakdown, String enddatebreakdown, String suspectheaterbreakdown, String stopheaterbreakdown, String messageheaterbreakdown, Heater iotheaterbreakdown) {
        this.numheaterbreakdown = numheaterbreakdown;
        this.startdateheaterbreakdown = startdateheaterbreakdown;
        this.enddatebreakdown = enddatebreakdown;
        this.suspectheaterbreakdown = suspectheaterbreakdown;
        this.stopheaterbreakdown = stopheaterbreakdown;
        this.messageheaterbreakdown = messageheaterbreakdown;
        this.iotheaterbreakdown = iotheaterbreakdown;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public String getEnddatebreakdown() {
        return enddatebreakdown;
    }

    public void setEnddatebreakdown(String enddatebreakdown) {
        this.enddatebreakdown = enddatebreakdown;
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

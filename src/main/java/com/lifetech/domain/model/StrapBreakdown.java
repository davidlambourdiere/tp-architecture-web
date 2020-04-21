package com.lifetech.domain.model;

import javax.persistence.*;

@Entity(name="strapbreakdown")
public class StrapBreakdown extends PersistableElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name="numstrapbreakdown")
    private String numstrapbreakdown;

    @Column(name="startdatestrapbreakdown")
    private String startdatestrapbreakdown;

    @Column(name="enddatestrapbreakdown")
    private String enddatestrapbreakdown;

    @Column(name="suspectstrapbreakdown")
    private String suspectstrapbreakdown;

    @Column(name="stopstrapbreakdown")
    private String stopstrapbreakdown;

    @Column(name="messagestrapbreakdown")
    private String messagestrapbreakdown;

    @ManyToOne(cascade = CascadeType.ALL)
    private Strap iotstrapbreakdown;

    public StrapBreakdown() {
    }

    public StrapBreakdown(String numstrapbreakdown, String startdatestrapbreakdown, String enddatestrapbreakdown, String suspectstrapbreakdown, String stopstrapbreakdown, String messagestrapbreakdown, Strap iotstrapbreakdown) {
        this.numstrapbreakdown = numstrapbreakdown;
        this.startdatestrapbreakdown = startdatestrapbreakdown;
        this.enddatestrapbreakdown = enddatestrapbreakdown;
        this.suspectstrapbreakdown = suspectstrapbreakdown;
        this.stopstrapbreakdown = stopstrapbreakdown;
        this.messagestrapbreakdown = messagestrapbreakdown;
        this.iotstrapbreakdown = iotstrapbreakdown;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

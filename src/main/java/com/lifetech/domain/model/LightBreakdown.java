package com.lifetech.domain.model;

import javax.persistence.*;

@Entity(name="lightbreakdown")
public class LightBreakdown extends PersistableElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name="numlightbreakdown")
    private String numlightbreakdown;

    @Column(name="startdatelightbreakdown")
    private String startdatelightbreakdown;

    @Column(name="enddatelightbreakdown")
    private String enddatelightbreakdown;

    @Column(name="suspectlightbreakdown")
    private String suspectlightbreakdown;

    @Column(name="stoplightbreakdown")
    private String stoplightbreakdown;

    @Column(name="messagelightbreakdown")
    private String messagelightbreakdown;

    @ManyToOne(cascade = CascadeType.ALL)
    private Light iotlightbreakdown;

    public LightBreakdown() {
    }

    public LightBreakdown(String numlightbreakdown, String startdatelightbreakdown, String enddatelightbreakdown, String suspectlightbreakdown, String stoplightbreakdown, String messagelightbreakdown, Light iotlightbreakdown) {
        this.numlightbreakdown = numlightbreakdown;
        this.startdatelightbreakdown = startdatelightbreakdown;
        this.enddatelightbreakdown = enddatelightbreakdown;
        this.suspectlightbreakdown = suspectlightbreakdown;
        this.stoplightbreakdown = stoplightbreakdown;
        this.messagelightbreakdown = messagelightbreakdown;
        this.iotlightbreakdown = iotlightbreakdown;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumlightbreakdown() {
        return numlightbreakdown;
    }

    public void setNumlightbreakdown(String numlightbreakdown) {
        this.numlightbreakdown = numlightbreakdown;
    }

    public String getStartdatelightbreakdown() {
        return startdatelightbreakdown;
    }

    public void setStartdatelightbreakdown(String startdatelightbreakdown) {
        this.startdatelightbreakdown = startdatelightbreakdown;
    }

    public String getEnddatelightbreakdown() {
        return enddatelightbreakdown;
    }

    public void setEnddatelightbreakdown(String enddatelightbreakdown) {
        this.enddatelightbreakdown = enddatelightbreakdown;
    }

    public String getSuspectlightbreakdown() {
        return suspectlightbreakdown;
    }

    public void setSuspectlightbreakdown(String suspectlightbreakdown) {
        this.suspectlightbreakdown = suspectlightbreakdown;
    }

    public String getStoplightbreakdown() {
        return stoplightbreakdown;
    }

    public void setStoplightbreakdown(String stoplightbreakdown) {
        this.stoplightbreakdown = stoplightbreakdown;
    }

    public String getMessagelightbreakdown() {
        return messagelightbreakdown;
    }

    public void setMessagelightbreakdown(String messagelightbreakdown) {
        this.messagelightbreakdown = messagelightbreakdown;
    }

    public Light getIotlightbreakdown() {
        return iotlightbreakdown;
    }

    public void setIotlightbreakdown(Light iotlightbreakdown) {
        this.iotlightbreakdown = iotlightbreakdown;
    }
}

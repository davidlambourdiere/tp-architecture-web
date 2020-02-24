package com.lifetech.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="heatermessage")
public class HeaterMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name="insertdate")
    private Date insertDate;

    @Column(name = "minvaluerefmessage")
    private String minvaluerefMessage;

    @Column(name = "maxvaluerefmessage")
    private String maxvaluerefMessage;

    @Column(name = "statemessage")
    private String stateMessage;

    @Column(name = "temperaturemessage")
    private String temperatureMessage;

    @ManyToOne(cascade = CascadeType.ALL)
    private Heater heater;

    public HeaterMessage(Date insertDate, String minvaluerefMessage, String maxvaluerefMessage, String stateMessage, String temperatureMessage, Heater heater) {
        this.insertDate = insertDate;
        this.minvaluerefMessage = minvaluerefMessage;
        this.maxvaluerefMessage = maxvaluerefMessage;
        this.stateMessage = stateMessage;
        this.temperatureMessage = temperatureMessage;
        this.heater = heater;
    }

    public HeaterMessage(){

    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getMinvaluerefMessage() {
        return minvaluerefMessage;
    }

    public void setMinvaluerefMessage(String minvaluerefMessage) {
        this.minvaluerefMessage = minvaluerefMessage;
    }

    public String getMaxvaluerefMessage() {
        return maxvaluerefMessage;
    }

    public void setMaxvaluerefMessage(String maxvaluerefMessage) {
        this.maxvaluerefMessage = maxvaluerefMessage;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getTemperatureMessage() {
        return temperatureMessage;
    }

    public void setTemperatureMessage(String temperatureMessage) {
        this.temperatureMessage = temperatureMessage;
    }

    public Heater getHeater() {
        return heater;
    }

    public void setHeater(Heater heater) {
        this.heater = heater;
    }
}

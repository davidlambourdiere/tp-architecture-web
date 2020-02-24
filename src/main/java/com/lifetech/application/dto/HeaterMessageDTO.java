package com.lifetech.application.dto;


import java.util.Date;

public class HeaterMessageDTO extends PersistableElementDTO {
    Date insertDate;
    String invaluerefMessage;
    String maxvaluerefMessage;
    String stateMessage;
    String temperatureMessage;
    HeaterDTO heater;

    public HeaterMessageDTO() {
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getInvaluerefMessage() {
        return invaluerefMessage;
    }

    public void setInvaluerefMessage(String invaluerefMessage) {
        this.invaluerefMessage = invaluerefMessage;
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

    public HeaterDTO getHeater() {
        return heater;
    }

    public void setHeater(HeaterDTO heater) {
        this.heater = heater;
    }
}

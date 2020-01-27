package com.lifetech.application.dto;

public class HeaterDetailDTO extends PersistableElementDTO{
    private HeaterDTO heater;
    private String percentageOnLastMonth;

    public HeaterDetailDTO() {
    }

    public HeaterDTO getHeater() {
        return heater;
    }

    public void setHeater(HeaterDTO heater) {
        this.heater = heater;
    }

    public String getPercentageOnLastMonth() {
        return percentageOnLastMonth;
    }

    public void setPercentageOnLastMonth(String percentageOnLastMonth) {
        this.percentageOnLastMonth = percentageOnLastMonth;
    }

}

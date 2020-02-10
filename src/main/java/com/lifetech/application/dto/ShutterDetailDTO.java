package com.lifetech.application.dto;

public class ShutterDetailDTO extends PersistableElementDTO{
    private ShutterDTO shutter;
    private String percentageOnLastMonth;
    private String percentage;

    public ShutterDetailDTO() {
    }

    public ShutterDTO getShutter() {
        return shutter;
    }

    public void setShutter(ShutterDTO shutter) {
        this.shutter = shutter;
    }

    public String getPercentageOnLastMonth() {
        return percentageOnLastMonth;
    }

    public void setPercentageOnLastMonth(String percentageOnLastMonth) {
        this.percentageOnLastMonth = percentageOnLastMonth;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}

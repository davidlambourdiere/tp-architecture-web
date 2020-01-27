package com.lifetech.application.dto;

public class LightDetailDTO  extends PersistableElementDTO{
    private LightDTO light;
    private String percentageOnLastMonth;
    private String percentage;
    private String color;

    public LightDetailDTO() {
    }

    public LightDTO getLight() {
        return light;
    }

    public void setLight(LightDTO light) {
        this.light = light;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

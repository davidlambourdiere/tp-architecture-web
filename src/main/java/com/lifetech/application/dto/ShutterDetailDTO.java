package com.lifetech.application.dto;

import java.util.List;

public class ShutterDetailDTO extends PersistableElementDTO{
    private ShutterDTO shutter;
    private String percentageOnLastMonth;
    private String percentage;
    private boolean usedlastmonth;
    private List<ShutterHistoricDTO> shutterhistorics;

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

    public List<ShutterHistoricDTO> getShutterhistorics() {
        return shutterhistorics;
    }

    public void setShutterhistorics(List<ShutterHistoricDTO> shutterhistorics) {
        this.shutterhistorics = shutterhistorics;
    }

    public boolean isUsedlastmonth() {
        return usedlastmonth;
    }

    public void setUsedlastmonth(boolean usedlastmonth) {
        this.usedlastmonth = usedlastmonth;
    }
}

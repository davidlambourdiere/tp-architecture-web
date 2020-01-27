package com.lifetech.application.dto;

public class ClockDetailDTO extends PersistableElementDTO{
    private ClockDTO clock;
    private String percentageOnLastMonth;

    public ClockDetailDTO() {
    }

    public ClockDTO getClock() {
        return clock;
    }

    public void setClock(ClockDTO clock) {
        this.clock = clock;
    }

    public String getPercentageOnLastMonth() {
        return percentageOnLastMonth;
    }

    public void setPercentageOnLastMonth(String percentageOnLastMonth) {
        this.percentageOnLastMonth = percentageOnLastMonth;
    }
}

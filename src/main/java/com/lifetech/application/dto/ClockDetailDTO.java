package com.lifetech.application.dto;

import java.util.List;

public class ClockDetailDTO extends PersistableElementDTO{
    private ClockDTO clock;
    private String percentageOnLastMonth;
    private List<ClockHistoricDTO> clockhistorics;
    private boolean usedlastmonth;

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

    public boolean isUsedlastmonth() {
        return usedlastmonth;
    }

    public void setUsedlastmonth(boolean usedlastmonth) {
        this.usedlastmonth = usedlastmonth;
    }

    public List<ClockHistoricDTO> getClockhistorics() {
        return clockhistorics;
    }

    public void setClockhistorics(List<ClockHistoricDTO> clockhistorics) {
        this.clockhistorics = clockhistorics;
    }
}

package com.lifetech.application.dto;

import com.lifetech.domain.model.HeaterHistoric;

import java.util.List;

public class HeaterDetailDTO extends PersistableElementDTO{
    private HeaterDTO heater;
    private String percentageOnLastMonth;
    private List<HeaterHistoricDTO> heaterhistorics;
    private boolean usedlastmonth;

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

    public List<HeaterHistoricDTO> getHeaterhistorics() {
        return heaterhistorics;
    }

    public void setHeaterhistorics(List<HeaterHistoricDTO> heaterhistorics) {
        this.heaterhistorics = heaterhistorics;
    }

    public boolean isUsedlastmonth() {
        return usedlastmonth;
    }

    public void setUsedlastmonth(boolean usedlastmonth) {
        this.usedlastmonth = usedlastmonth;
    }
}

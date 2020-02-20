package com.lifetech.application.dto;

import java.util.List;

public class StrapDetailDTO extends PersistableElementDTO {
    private StrapDTO strap;
    private String percentageOnLastMonth;
    private List<StrapHistoricDTO> straphistorics;

    public StrapDetailDTO() {
    }

    public StrapDTO getStrap() {
        return strap;
    }

    public void setStrap(StrapDTO strap) {
        this.strap = strap;
    }

    public String getPercentageOnLastMonth() {
        return percentageOnLastMonth;
    }

    public void setPercentageOnLastMonth(String percentageOnLastMonth) {
        this.percentageOnLastMonth = percentageOnLastMonth;
    }

    public List<StrapHistoricDTO> getStraphistorics() {
        return straphistorics;
    }

    public void setStraphistorics(List<StrapHistoricDTO> straphistorics) {
        this.straphistorics = straphistorics;
    }
}

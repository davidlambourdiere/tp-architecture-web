package com.lifetech.application.dto;

public class StrapDetailDTO extends PersistableElementDTO {
    private StrapDTO strap;
    private String percentageOnLastMonth;

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

}

package com.lifetech.application.dto;

import java.util.List;

public class LightDetailDTO  extends PersistableElementDTO{
    private LightDTO light;
    private String percentageOnLastMonth;
    private List<LightHistoricDTO> lightshistoric;

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

    public List<LightHistoricDTO> getLightshistoric() {
        return lightshistoric;
    }

    public void setLightshistoric(List<LightHistoricDTO> lightshistoric) {
        this.lightshistoric = lightshistoric;
    }
}

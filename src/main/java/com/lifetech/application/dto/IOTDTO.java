package com.lifetech.application.dto;

import java.util.List;

public class IOTDTO {
    private List<ClockDTO> clocks;
    private List<HeaterDTO> heaters;
    private List<LightDTO> lights;
    private List<ShutterDTO> shutters;
    private List<StrapDTO> straps;


    public IOTDTO() {
    }

    public List<ClockDTO> getClocks() {
        return clocks;
    }

    public void setClocks(List<ClockDTO> clocks) {
        this.clocks = clocks;
    }

    public List<HeaterDTO> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<HeaterDTO> heaters) {
        this.heaters = heaters;
    }

    public List<LightDTO> getLights() {
        return lights;
    }

    public void setLights(List<LightDTO> lights) {
        this.lights = lights;
    }

    public List<ShutterDTO> getShutters() {
        return shutters;
    }

    public void setShutters(List<ShutterDTO> shutters) {
        this.shutters = shutters;
    }

    public List<StrapDTO> getStraps() {
        return straps;
    }

    public void setStraps(List<StrapDTO> straps) {
        this.straps = straps;
    }
}

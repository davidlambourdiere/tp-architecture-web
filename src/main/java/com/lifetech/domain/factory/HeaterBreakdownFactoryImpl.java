package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterBreakdown;

public class HeaterBreakdownFactoryImpl implements HeaterBreakdownFactory {
    @Override
    public HeaterBreakdown createHeaterBreakdown() {
        return new HeaterBreakdown();
    }

    @Override
    public HeaterBreakdown createHeaterBreakdown(String numheaterbreakdown, String startdateheaterbreakdown, String enddatebreakdown, String suspectheaterbreakdown, String stopheaterbreakdown, String messageheaterbreakdown, Heater iotheaterbreakdown) {
        return new HeaterBreakdown(numheaterbreakdown,startdateheaterbreakdown,enddatebreakdown,suspectheaterbreakdown,stopheaterbreakdown,messageheaterbreakdown,iotheaterbreakdown);
    }
}

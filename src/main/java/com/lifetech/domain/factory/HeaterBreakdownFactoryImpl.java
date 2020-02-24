package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterBreakdown;

import java.sql.Timestamp;

public class HeaterBreakdownFactoryImpl implements HeaterBreakdownFactory {
    @Override
    public HeaterBreakdown createRandomHeaterBreakdown(Heater heater) {
        HeaterBreakdown heaterBreakdown = new HeaterBreakdown();
        heaterBreakdown.setStartdateheaterbreakdown((new Timestamp(System.currentTimeMillis())).toString());
        heaterBreakdown.setEnddatebreakdown((new Timestamp(System.currentTimeMillis() + 86400)).toString());
        heaterBreakdown.setMessageheaterbreakdown("PANNE");
        heaterBreakdown.setIotheaterbreakdown(heater);
        return heaterBreakdown;
    }
    @Override
    public HeaterBreakdown createHeaterBreakdown () {
        return new HeaterBreakdown();
    }

    @Override
    public HeaterBreakdown createHeaterBreakdown (String numheaterbreakdown, String startdateheaterbreakdown, String enddatebreakdown, String suspectheaterbreakdown, String stopheaterbreakdown, String messageheaterbreakdown, Heater iotheaterbreakdown){
        return new HeaterBreakdown(numheaterbreakdown, startdateheaterbreakdown, enddatebreakdown, suspectheaterbreakdown, stopheaterbreakdown, messageheaterbreakdown, iotheaterbreakdown);
    }
}

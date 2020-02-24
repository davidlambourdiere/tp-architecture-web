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
}

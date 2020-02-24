package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterBreakdown;

public interface HeaterBreakdownFactory {
    HeaterBreakdown createHeaterBreakdown();

    HeaterBreakdown createHeaterBreakdown(String numheaterbreakdown, String startdateheaterbreakdown, String enddatebreakdown, String suspectheaterbreakdown, String stopheaterbreakdown, String messageheaterbreakdown, Heater iotheaterbreakdown);
}

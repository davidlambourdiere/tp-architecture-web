package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterBreakdown;

public interface HeaterBreakdownFactory {
    HeaterBreakdown createRandomHeaterBreakdown(Heater heater);
}

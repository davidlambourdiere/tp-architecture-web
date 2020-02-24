package com.lifetech.domain.factory;

import com.lifetech.domain.model.ClockHistoric;
import org.springframework.stereotype.Component;

@Component
public class ClockHistoricFactoryImpl implements ClockHistoricFactory{
    @Override
    public ClockHistoric createClockHistoric() {
        return new ClockHistoric();
    }
}

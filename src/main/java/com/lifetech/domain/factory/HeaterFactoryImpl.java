package com.lifetech.domain.factory;

import com.lifetech.domain.model.Heater;
import org.springframework.stereotype.Component;

@Component
public class HeaterFactoryImpl implements HeaterFactory {
    @Override
    public Heater createHeater() {
        return new Heater();
    }
}

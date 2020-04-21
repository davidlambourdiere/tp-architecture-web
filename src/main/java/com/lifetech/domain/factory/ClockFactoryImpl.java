package com.lifetech.domain.factory;

import com.lifetech.domain.model.Clock;
import org.springframework.stereotype.Component;

@Component
public class ClockFactoryImpl implements ClockFactory{
    @Override
    public Clock createClock() {
        return new Clock();
    }
}

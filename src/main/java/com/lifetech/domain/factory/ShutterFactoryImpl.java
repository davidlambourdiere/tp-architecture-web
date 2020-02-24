package com.lifetech.domain.factory;

import com.lifetech.domain.model.Shutter;
import org.springframework.stereotype.Component;

@Component
public class ShutterFactoryImpl implements ShutterFactory{
    @Override
    public Shutter createShutter() {
        return new Shutter();
    }
}

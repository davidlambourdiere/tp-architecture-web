package com.lifetech.domain.factory;

import com.lifetech.domain.model.ShutterHistoric;
import org.springframework.stereotype.Component;

@Component
public class ShutterHistoricFactoryImpl implements ShutterHistoricFactory {
    @Override
    public ShutterHistoric createShutterHistoric() {
        return new ShutterHistoric();
    }
}

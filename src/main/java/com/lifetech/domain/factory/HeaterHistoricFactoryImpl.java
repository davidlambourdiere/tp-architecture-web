package com.lifetech.domain.factory;

import com.lifetech.domain.model.HeaterHistoric;
import org.springframework.stereotype.Component;

@Component
public class HeaterHistoricFactoryImpl implements HeaterHistoricFactory {
    @Override
    public HeaterHistoric createHeaterHistoric() {
        return new HeaterHistoric();
    }
}

package com.lifetech.domain.factory;

import com.lifetech.domain.model.StrapHistoric;
import org.springframework.stereotype.Component;

@Component
public class StrapHistoricFactoryImpl implements StrapHistoricFactory {
    @Override
    public StrapHistoric createStrapHistoric() {
        return new StrapHistoric();
    }
}

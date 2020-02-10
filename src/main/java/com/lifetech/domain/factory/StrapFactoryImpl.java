package com.lifetech.domain.factory;

import com.lifetech.domain.model.Strap;
import org.springframework.stereotype.Component;

@Component
public class StrapFactoryImpl implements StrapFactory{
    @Override
    public Strap createStrap() {
        return new Strap();
    }
}

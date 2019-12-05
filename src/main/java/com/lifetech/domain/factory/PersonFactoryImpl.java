package com.lifetech.domain.factory;

import com.lifetech.domain.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonFactoryImpl implements PersonFactory {
    public Person createPerson() {
        return new Person();
    }
}

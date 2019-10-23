package com.lifetech.domain.factory;

import com.lifetech.domain.model.Person;

public class PersonFactoryImpl implements PersonFactory {
    public Person createPerson() {
        Person person = new Person();
        return person;
    }

    public Person createPerson(String name, String lastName) {
        Person person = new Person(name, lastName);
        return person;
    }
}

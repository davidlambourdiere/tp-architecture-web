package com.lifetech.domain.factory;

import com.lifetech.domain.model.Person;

public interface PersonFactory {
    Person createPerson();
    Person createPerson(String name, String lastName);
}

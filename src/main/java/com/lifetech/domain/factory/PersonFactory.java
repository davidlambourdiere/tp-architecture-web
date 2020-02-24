package com.lifetech.domain.factory;

import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Residence;

public interface PersonFactory {
    Person createPerson();

    Person createRandomPerson(Residence residence);
}

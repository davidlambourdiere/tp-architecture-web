package com.lifetech.domain.service;

import com.lifetech.domain.model.Person;

import java.util.List;

public interface PersonService {
    boolean verifyConnection(List<Person> people, Person person);
}

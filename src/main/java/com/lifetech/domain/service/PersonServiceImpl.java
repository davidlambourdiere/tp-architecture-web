package com.lifetech.domain.service;

import com.lifetech.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    public Person verifyConnection(List<Person> people, Person person) {
        for (Person personToCheck: people){
            if(personToCheck.getLogin().equals(person.getLogin())){
                if(personToCheck.getPassword().equals(person.getPassword())){
                    return personToCheck;
                }
            }

        }
        for (Person profileToCheck: people){
            if(profileToCheck.getProfiletype().equals(person.getProfiletype())){
                return profileToCheck;
            }

        }
        return null;
    }
}

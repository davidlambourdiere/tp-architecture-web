package com.lifetech.domain.factory;

import com.lifetech.domain.model.Person;

import com.lifetech.domain.model.Residence;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class PersonFactoryImpl implements PersonFactory {
    String[] firstnameList = {"David", "Mohamed", "Kadia", "Hella", "Louis", "Marie", "Nawfal", "Bakary","Henry","Alexis", "Tristan", "Lucas", "Emilie", "Laura"};
    String[] lastnameList = {"Robert","Dubois", "Durand", "Leroux","Germain", "Leveque", "Jacquet", "Lamy","Delaunay","Giraud", "Laporte", "Monnier", "Hamon", "Gaillard", "Emmam", "Toure","Beaudoin", "Gonzales"};
    public PersonFactoryImpl() {
        
    }

    public Person createPerson() {
        return new Person();
    }

    @Override
    public Person createRandomPerson(Residence residence) {
        Person person = new Person();
        person.setFirstName(getRandomFirstName());
        person.setLastName(getRandomLastName().toUpperCase());
        person.setLogin(person.getFirstName().toLowerCase() +person.getLastName().toLowerCase());
        person.setPassword(person.getLogin());
        person.setAverageincome(String.valueOf(1500+ ThreadLocalRandom.current().nextInt(1500)));
        person.setIsmobile((ThreadLocalRandom.current().nextBoolean()) ? "true" : "false");
        person.setEmail(person.getLogin() + "@mail.lifetech.fr");
        person.setResidence(residence);
        return person;
    }

    private String getRandomLastName() {
        return lastnameList[ThreadLocalRandom.current().nextInt(lastnameList.length)];
    }

    private String getRandomFirstName() {
        return firstnameList[ThreadLocalRandom.current().nextInt(firstnameList.length)];
    }
}

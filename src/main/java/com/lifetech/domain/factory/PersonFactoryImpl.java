package com.lifetech.domain.factory;

import com.lifetech.domain.model.Person;

import com.lifetech.domain.model.Residence;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PersonFactoryImpl implements PersonFactory {
    String[] firstnameList = {"David", "Mohamed", "Kadia", "Hella", "Louis", "Marie", "Nawfal", "Bakary","Henry"};
    String[] lastnameList = {"Robert","Dubois", "Durand", "Leroux","Germain", "Leveque", "Jacquet", "Lamy","Delaunay","Giraud", "Laporte", "Monnier", "Hamon", "Gaillard", "Emmam", "Toure","Beaudoin", "Gonzales"};
    Random rd = new Random();
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
        person.setAverageincome(String.valueOf(1500+ rd.nextInt(1500)));
        person.setIsmobile((rd.nextBoolean()) ? "true" : "false");
        person.setEmail(person.getLogin() + "@mail.lifetech.fr");
        person.setResidence(residence);
        return person;
    }

    private String getRandomLastName() {
        return lastnameList[rd.nextInt(lastnameList.length)];
    }

    private String getRandomFirstName() {
        return firstnameList[rd.nextInt(firstnameList.length)];
    }
}

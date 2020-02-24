package com.lifetech.application.manager;

import com.lifetech.domain.dao.*;
import com.lifetech.domain.factory.*;
import com.lifetech.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MockForActivityAnalysisManagerImpl implements MockForActivityAnalysisManager {
    private final ResidenceDAO residenceDAO;
    private final PersonDAO personDAO;
    private final RoomDAO roomDAO;
    private final HeaterDAO heaterDAO;
    private final HeaterBreakdownDAO heaterBreakdownDAO;
    private static final Logger LOG = LoggerFactory.getLogger(MockForActivityAnalysisManager.class);
    public MockForActivityAnalysisManagerImpl(ResidenceDAO residenceDAO, PersonDAO personDAO, RoomDAO roomDAO, HeaterDAO heaterDAO, HeaterBreakdownDAO heaterBreakdownDAO) {
        this.residenceDAO = residenceDAO;
        this.personDAO = personDAO;
        this.roomDAO = roomDAO;
        this.heaterDAO = heaterDAO;
        this.heaterBreakdownDAO = heaterBreakdownDAO;
    }

    @Override
    public String mock() {
        //Clear the tables

        //Create 2 residences
        Residence residence1 = new Residence();
        residence1.setAdress("25 Rue du Pont");
        residence1.setPhone("0665623581");
        residence1.setCreationdate(new Timestamp(System.currentTimeMillis()));
        residence1.setEmail("residencedupont@mail.fr");
        residence1.setName("Residence Du Pont");

        Residence residence2 = new Residence();
        residence2.setAdress("2 Rue Jean Jaurès");
        residence2.setPhone("0665623581");
        residence2.setCreationdate(new Timestamp(System.currentTimeMillis()));
        residence2.setEmail("residencejeanjaurès@mail.fr");
        residence2.setName("Residence Jean Jaurès");

        List<Residence> residenceList = new ArrayList<Residence>();
        residenceList.add(residence1);
        residenceList.add(residence2);
        residenceDAO.saveAll(residenceList);

        //Populate each residence
        PersonFactory personFactory = new PersonFactoryImpl();
        HeaterFactory heaterFactory = new HeaterFactoryImpl();
        HeaterBreakdownFactory heaterBreakdownFactory = new HeaterBreakdownFactoryImpl();
        for (Residence residence : residenceList) {
            List<Person> personList = new ArrayList<Person>();
            List<Room> roomList = new ArrayList<Room>();
            List<Heater> heaterList = new ArrayList<Heater>();
            for (int i = 0; i < 100; i++) {
                //Create a person
                Person person = personFactory.createRandomPerson(residence);
                personList.add(person);

                //Create a room for this person
                Room room = new Room();
                room.setNum(residence.getId().toString() + "_" + (i+1));
                roomList.add(room);

                //Create a heater for this room
                Heater heater = heaterFactory.createRandomHeater(person, room);
                heaterList.add(heater);

                if (heater.getBreakdownstatus().equals(StatusEnum.BREAKDOWN)) {
                    for (int j = 1; j < 10; j++) {
                        HeaterBreakdown heaterBreakdown = heaterBreakdownFactory.createRandomHeaterBreakdown(heater);
                        heaterBreakdownDAO.save(heaterBreakdown);
                    }
                }
            }
            personDAO.saveAll(personList);
            roomDAO.saveAll(roomList);
            heaterDAO.saveAll(heaterList);
        }
        return "Mocking";
    }
}

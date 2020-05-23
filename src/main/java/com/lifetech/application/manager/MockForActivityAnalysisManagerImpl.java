package com.lifetech.application.manager;

import com.lifetech.domain.dao.*;
import com.lifetech.domain.factory.*;
import com.lifetech.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Implementation of MockForActivityAnalysisManager interface
 * @author David Lambourdiere
 * */
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

    /**
     * This method fill the database with a random data sets
     *
     * @param nBreakdowns*/
    @Override
    public String mock(long nBreakdowns) {
        long startTime = System.currentTimeMillis();
        LOG.info("Start");
        //Create 2 residences
        Residence residence1 = new Residence();
        residence1.setAdress("25 Rue du Pont");
        residence1.setPhone("0665623581");
        residence1.setCreationdate(new Timestamp(1568016000000L)); // 09 Septembre 2019 08:00:00
        residence1.setEmail("residencedupont@mail.fr");
        residence1.setName("Residence Du Pont");

        Residence residence2 = new Residence();
        residence2.setAdress("2 Rue Jean Jaurès");
        residence2.setPhone("0665623581");
        residence2.setCreationdate(new Timestamp(1536480000000L)); // 09 Septembre 2018 08:00:00
        residence2.setEmail("residencejeanjaurès@mail.fr");
        residence2.setName("Residence Jean Jaurès");
        List<Residence> residenceList = new ArrayList<Residence>();
        residenceList.add(residence1);
        residenceList.add(residence2);
        residenceDAO.saveAll(residenceList);
        LOG.info("2 residences created");

        //Populate each residence
        PersonFactory personFactory = new PersonFactoryImpl();
        HeaterFactory heaterFactory = new HeaterFactoryImpl();
        HeaterBreakdownFactory heaterBreakdownFactory = new HeaterBreakdownFactoryImpl();
        for (Residence residence : residenceList) { //For each residence
            List<Person> personList = new ArrayList<Person>();
            List<Room> roomList = new ArrayList<Room>();
            List<Heater> heaterList = new ArrayList<Heater>();

            for (int i = 0; i < 100; i++) {//Create 100 persons and rooms
                Person person = personFactory.createRandomPerson(residence);
                personList.add(person);

                //Create a room for this person
                Room room = new Room();
                room.setNum(residence.getId().toString() + "_" + (i + 1));
                roomList.add(room);
            }
            LOG.info("100 persons and 100 rooms created");
            for (int i = 0; i < 100; i++) {//Create 100 heaters
                Heater heater = heaterFactory.createRandomHeater(personList.get(i), roomList.get(i), 0.8, residence.getCreationdate());
                heaterList.add(heater);
            }
            LOG.info("100 heaters created");

            for (int i = 0; i < nBreakdowns; i++) {//Create nBreakdowns heater breakdowns
                Heater randomHeater = heaterList.get(ThreadLocalRandom.current().nextInt(heaterList.size()));
                if (randomHeater.getBreakdownstatus() == StatusEnum.BREAKDOWN) {
                    HeaterBreakdown heaterBreakdown = heaterBreakdownFactory.createRandomHeaterBreakdown(randomHeater, Timestamp.valueOf(randomHeater.getActivationDate()));
                    heaterBreakdownDAO.save(heaterBreakdown);
                }
            }
            LOG.info(nBreakdowns + "heaters breakdowns created");

            personDAO.saveAll(personList);
            roomDAO.saveAll(roomList);
            heaterDAO.saveAll(heaterList);
        }
        LOG.info("Ended in " + (System.currentTimeMillis() - startTime)/1000 + " seconds");
        return "MockForActivityAnalysisManager";
    }

}

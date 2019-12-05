package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonManagerImpl implements PersonManager {

    private final PersonDAO personDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    private final PersonService personService;

    public PersonManagerImpl(OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO, PersonService personService) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
        this.personService = personService;
    }

    public List<PersonDTO> findAll() {
        return orikaBeanMapper.mapAsList(personDAO.findAll(), PersonDTO.class);
    }

    @Override
    public PersonDTO verifyConnexion(PersonDTO connectedLogs) {
        List<Person> people = personDAO.findAll();
        Person person = orikaBeanMapper.map(connectedLogs, Person.class);
        return orikaBeanMapper.map(personService.verifyConnection(people, person), PersonDTO.class);
    }
}

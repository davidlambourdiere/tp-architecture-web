package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.PersonStatus;
import com.lifetech.domain.service.PersonService;
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

    public List<PersonDTO> findAll() {return orikaBeanMapper.mapAsList(personDAO.findAll(), PersonDTO.class);
    }

    @Override
    public PersonDTO verifyConnexion(PersonDTO connectedLogs) {
        List<Person> people = personDAO.findAll();
        Person person = orikaBeanMapper.map(connectedLogs, Person.class);
        return orikaBeanMapper.map(personService.verifyConnection(people, person), PersonDTO.class);
    }

    @Override
    public PersonDTO findById(String id) {
        return orikaBeanMapper.map(personDAO.findById(Long.parseLong(id)).orElse(null), PersonDTO.class);
    }

    @Override
    public int findNumberOfPersonByRole(PersonStatus personStatus) {
        return personDAO.countByUserrole(personStatus);
    }

    @Override
    public List<PersonDTO> findPersonByRole(PersonStatus personStatus) {
        return orikaBeanMapper.mapAsList(personDAO.findByUserrole(personStatus), PersonDTO.class);
    }

    @Override
    public List<PersonDTO> findResidentsByName(String query) {
        return  orikaBeanMapper.mapAsList(personDAO.findByUserroleAndFirstName(PersonStatus.RESIDENT, query), PersonDTO.class);
    }
}

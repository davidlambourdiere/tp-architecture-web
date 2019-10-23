package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonManagerImpl implements PersonManager {

    private final PersonDAO personDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public PersonManagerImpl(OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
    }

    public List<PersonDTO> findAll() {
        return orikaBeanMapper.mapAsList(personDAO.findAll(), PersonDTO.class);
    }
}

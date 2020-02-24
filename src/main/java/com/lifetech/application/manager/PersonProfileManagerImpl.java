package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonProfileDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonProfileDAO;
import com.lifetech.domain.model.PersonProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonProfileManagerImpl implements PersonProfileManager{

    private final PersonProfileDAO personProfileDAO;
    private final OrikaBeanMapper orikaBeanMapper;

    public PersonProfileManagerImpl(PersonProfileDAO personProfileDAO, OrikaBeanMapper orikaBeanMapper) {
        this.personProfileDAO = personProfileDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    public List<PersonProfileDTO> findAll() {

        return orikaBeanMapper.mapAsList(personProfileDAO.findAll(), PersonProfileDTO.class);

    }

    public  PersonProfileDTO save(PersonProfileDTO updatedpersonProfile) {
        PersonProfile p = personProfileDAO.save(orikaBeanMapper.map(updatedpersonProfile, PersonProfile.class));
        return orikaBeanMapper.map(p, PersonProfileDTO.class);
    }
}

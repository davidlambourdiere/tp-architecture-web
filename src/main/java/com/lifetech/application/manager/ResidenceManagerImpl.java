package com.lifetech.application.manager;

import com.lifetech.application.dto.ResidenceDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.dao.ResidenceDAO;
import com.lifetech.domain.model.Residence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResidenceManagerImpl implements ResidenceManager {

    private final ResidenceDAO residenceDAO;
    private OrikaBeanMapper orikaBeanMapper;

    public ResidenceManagerImpl(OrikaBeanMapper orikaBeanMapper, ResidenceDAO residenceDAO) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.residenceDAO = residenceDAO;
    }

    @Override
    public List<ResidenceDTO> findAll() {
        return orikaBeanMapper.mapAsList(residenceDAO.findAll(),ResidenceDTO.class);
    }
}

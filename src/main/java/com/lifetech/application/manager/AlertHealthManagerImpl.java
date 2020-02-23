package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.AlertHealthDAO;
import com.lifetech.domain.model.AlertHealth;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AlertHealthManagerImpl implements AlertHealthManager {

    private final AlertHealthDAO alertHealthDAO;
    private  final StrapManager strapManager;
    private  final PersonManager personManager;
    private final OrikaBeanMapper orikaBeanMapper;


    public AlertHealthManagerImpl(OrikaBeanMapper orikaBeanMapper, AlertHealthDAO alertHealthDAO, StrapManager strapManager, PersonManager personManager) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.alertHealthDAO = alertHealthDAO;
        this.strapManager = strapManager;
        this.personManager = personManager;
    }

    public List<AlertHealthDTO> findAll() {
        //get Strap by alerts
        List<AlertHealth> alertHealths = alertHealthDAO.findAll();
        List<AlertHealthDTO> alertHealthsDTO = orikaBeanMapper.mapAsList(alertHealths, AlertHealthDTO.class);
        for (int i =0; i<alertHealths.size(); i++ ) {
                alertHealthsDTO.get(i).setStrap(strapManager.findById(String.valueOf(alertHealths.get(i).getStrap())));
                alertHealthsDTO.get(i).setDoctor(personManager.findById(String.valueOf(alertHealths.get(i).getDoctor())));
        }

        return alertHealthsDTO;
    }


}

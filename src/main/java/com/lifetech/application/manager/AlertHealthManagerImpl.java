package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.application.dto.StrapDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.AlertHealthDAO;
import com.lifetech.domain.dao.StrapDAO;
import com.lifetech.domain.model.AlertHealth;
import com.lifetech.domain.model.Strap;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AlertHealthManagerImpl implements AlertHealthManager {

    private final AlertHealthDAO alertHealthDAO;
    private  final StrapManager strapManager;
    private final OrikaBeanMapper orikaBeanMapper;


    public AlertHealthManagerImpl(OrikaBeanMapper orikaBeanMapper, AlertHealthDAO alertHealthDAO, StrapManager strapManager) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.alertHealthDAO = alertHealthDAO;
        this.strapManager = strapManager;
    }

    public List<AlertHealthDTO> findAll() {
        //get Strap by alerts
        List<AlertHealth> alertHealths = alertHealthDAO.findAll();
        List<AlertHealthDTO> alertHealthsDTO = orikaBeanMapper.mapAsList(alertHealths, AlertHealthDTO.class);
        for (int i =0; i<alertHealths.size(); i++ ) {
                alertHealthsDTO.get(i).setStrap(strapManager.findById(String.valueOf(alertHealths.get(i).getStrap())));
        }

        return alertHealthsDTO;
    }


}

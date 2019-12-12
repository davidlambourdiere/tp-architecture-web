package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaterManagerImpl implements HeaterManager{

    private final HeaterDAO heaterDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public HeaterManagerImpl(HeaterDAO heaterDAO, OrikaBeanMapper orikaBeanMapper) {
        this.heaterDAO = heaterDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    public HeaterDTO findById(String id) {
        return null;
    }
}

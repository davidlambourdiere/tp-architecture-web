package com.lifetech.application.manager;

import com.lifetech.application.dto.ClockDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ClockDAO;
import com.lifetech.domain.model.Clock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockManagerImpl implements  ClockManager {

    private final ClockDAO clockDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public ClockManagerImpl(ClockDAO clockDAO, OrikaBeanMapper orikaBeanMapper) {
        this.clockDAO = clockDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }


    @Override
    public ClockDTO findById(String id) {
        Clock clock = clockDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(clock, ClockDTO.class);
    }
}

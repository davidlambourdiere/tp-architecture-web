package com.lifetech.application.manager;

import com.lifetech.application.dto.LightBreakdownDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.LightBreakdownDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightBreakdownManagerImpl implements LightBreakdownManager {

    private final LightBreakdownDAO lightbreakdownDAO;

    private final OrikaBeanMapper orikaBeanMapper;


    public LightBreakdownManagerImpl(LightBreakdownDAO lightbreakdownDAO, OrikaBeanMapper orikaBeanMapper) {
        this.lightbreakdownDAO = lightbreakdownDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public List<LightBreakdownDTO> findAllLightBreakdown() {
        return orikaBeanMapper.mapAsList(lightbreakdownDAO.findAll(), LightBreakdownDTO.class);
    }


    /*public List<ClockBreakdownDTO> findBreakdownByClock(String id) {
        Clock clock = clockDAO.findById(Long.parseLong(id)).orElse(null);
        List<ClockBreakdown> breakdownsClock = breakdownDAO.findBreakdownByClock(clock);
        return orikaBeanMapper.mapAsList(breakdownsClock, ClockBreakdownDTO.class);
    }*/

}

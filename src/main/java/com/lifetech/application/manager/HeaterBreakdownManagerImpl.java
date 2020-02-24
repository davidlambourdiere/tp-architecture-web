package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterBreakdownDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterBreakdownDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaterBreakdownManagerImpl implements HeaterBreakdownManager {

    private final HeaterBreakdownDAO heaterBreakdownDAO;

    private final OrikaBeanMapper orikaBeanMapper;


    public HeaterBreakdownManagerImpl(HeaterBreakdownDAO heaterBreakdownDAO, OrikaBeanMapper orikaBeanMapper) {
        this.heaterBreakdownDAO = heaterBreakdownDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public List<HeaterBreakdownDTO> findAllHeaterBreakdown() {
        return orikaBeanMapper.mapAsList(heaterBreakdownDAO.findAll(), HeaterBreakdownDTO.class);
    }




    /*public List<ClockBreakdownDTO> findBreakdownByClock(String id) {
        Clock clock = clockDAO.findById(Long.parseLong(id)).orElse(null);
        List<ClockBreakdown> breakdownsClock = breakdownDAO.findBreakdownByClock(clock);
        return orikaBeanMapper.mapAsList(breakdownsClock, ClockBreakdownDTO.class);
    }*/

}

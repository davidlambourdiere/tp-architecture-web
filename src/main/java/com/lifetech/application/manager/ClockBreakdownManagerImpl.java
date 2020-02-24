package com.lifetech.application.manager;

import com.lifetech.application.dto.ClockBreakdownDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClockBreakdownManagerImpl implements ClockBreakdownManager {

    private final ClockBreakdownDAO clockBreakdownDAO;

    private final OrikaBeanMapper orikaBeanMapper;


    public ClockBreakdownManagerImpl(ClockBreakdownDAO clockBreakdownDAO, OrikaBeanMapper orikaBeanMapper) {
        this.clockBreakdownDAO = clockBreakdownDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public List<ClockBreakdownDTO> findAllClockBreakdown() {
        return orikaBeanMapper.mapAsList(clockBreakdownDAO.findAll(), ClockBreakdownDTO.class);
    }


    /*public List<ClockBreakdownDTO> findBreakdownByClock(String id) {
        Clock clock = clockDAO.findById(Long.parseLong(id)).orElse(null);
        List<ClockBreakdown> breakdownsClock = breakdownDAO.findBreakdownByClock(clock);
        return orikaBeanMapper.mapAsList(breakdownsClock, ClockBreakdownDTO.class);
    }*/

}

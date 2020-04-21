package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapBreakdownDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.StrapBreakdownDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrapBreakdownManagerImpl implements StrapBreakdownManager {

    private final StrapBreakdownDAO strapBreakdownDAO;

    private final OrikaBeanMapper orikaBeanMapper;


    public StrapBreakdownManagerImpl(StrapBreakdownDAO strapBreakdownDAO, OrikaBeanMapper orikaBeanMapper) {
        this.strapBreakdownDAO = strapBreakdownDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public List<StrapBreakdownDTO> findAllStrapBreakdown() {
        return orikaBeanMapper.mapAsList(strapBreakdownDAO.findAll(), StrapBreakdownDTO.class);
    }


    /*public List<ClockBreakdownDTO> findBreakdownByClock(String id) {
        Clock clock = clockDAO.findById(Long.parseLong(id)).orElse(null);
        List<ClockBreakdown> breakdownsClock = breakdownDAO.findBreakdownByClock(clock);
        return orikaBeanMapper.mapAsList(breakdownsClock, ClockBreakdownDTO.class);
    }*/

}

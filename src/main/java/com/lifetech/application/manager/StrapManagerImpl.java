package com.lifetech.application.manager;

import com.lifetech.application.dto.RoomDTO;
import com.lifetech.application.dto.StrapDTO;
import com.lifetech.application.dto.StrapDetailDTO;
import com.lifetech.application.dto.StrapHistoricDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.LightDAO;
import com.lifetech.domain.dao.StrapDAO;
import com.lifetech.domain.dao.StrapHistoricDAO;
import com.lifetech.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StrapManagerImpl implements StrapManager {

    private static final Logger LOG = LoggerFactory.getLogger(StrapManagerImpl.class);

    private final StrapDAO strapDAO;

    private final LightDAO lightDAO;

    private final StrapHistoricDAO strapHistoricDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public StrapManagerImpl(StrapHistoricDAO strapHistoricDAO, StrapDAO strapDAO, OrikaBeanMapper orikaBeanMapper, LightDAO lightDAO) {
        this.strapHistoricDAO = strapHistoricDAO;
        this.strapDAO = strapDAO;
        this.lightDAO = lightDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public StrapDetailDTO findByHistoric(String id) {
        Strap strap = strapDAO.findById(Long.parseLong(id)).orElse(null);
        StrapDTO strapDTO = orikaBeanMapper.map(strap, StrapDTO.class);
        List<StrapHistoric> strapHistorics = strapHistoricDAO.findAllByStrapid(Long.parseLong(id));
        List<StrapHistoricDTO> strapHistoricDTOS = new ArrayList<>();
        boolean usedlastmonth = true;
        String percentageLastMonth = null;
        if (strapHistorics != null && !strapHistorics.isEmpty()) {

            for (StrapHistoric strapHistoric : strapHistorics) {
                StrapHistoricDTO strapHistoricDTO = new StrapHistoricDTO();
                strapHistoricDTO.setEndingdate(strapHistoric.getEndingDate().toString());
                strapHistoricDTO.setStartdate(strapHistoric.getStartDate().toString());
                strapHistoricDTO.setState(strapHistoric.getState().toString());
                strapHistoricDTO.setBreakdownstatus(strapHistoric.getBreakdownstatus().toString());
                strapHistoricDTOS.add(strapHistoricDTO);
            }
            float percentageOnLastMonth = calculateTimeOnLastMonth(strapHistorics);
            if (percentageOnLastMonth < 30 && percentageOnLastMonth > 0) {
                //TODO
                usedlastmonth = false;
            } else {
                usedlastmonth = true;
            }
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        StrapDetailDTO strapDetailDTO = new StrapDetailDTO();
        strapDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        strapDetailDTO.setStraphistorics(strapHistoricDTOS);
        strapDetailDTO.setUsedlastmonth(usedlastmonth);
        strapDetailDTO.setStrap(strapDTO);
        return strapDetailDTO;
    }

    @Override
    public List<Strap> findAllStrapMalFunctionning() {
        List<Strap> straps = strapDAO.findAll();
        List<StrapHistoric> strapHistorics = strapHistoricDAO.findAll();
        Set<Strap> distinctStrapsToReturn = new HashSet<>();
        for (Strap strap : straps) {
            List<StrapHistoric> historicToVerify = new ArrayList<>();
            for (StrapHistoric strapHistoric : strapHistorics) {
                if (strapHistoric.getStrapid().equals(strap.getId())) {
                    historicToVerify.add(strapHistoric);
                }
            }
            for (StrapHistoric strapHistoric : historicToVerify) {
                if (strapHistoric.getBreakdownstatus().equals(StatusEnum.BREAKDOWN)) {
                    distinctStrapsToReturn.add(strap);
                }
            }
            float timeOnLastMonth = calculateTimeOnLastMonth(historicToVerify);
            if (timeOnLastMonth < 30 && timeOnLastMonth > 0) {
                distinctStrapsToReturn.add(strap);
            }
        }
        List<Strap> strapsToReturn = new ArrayList<>();
        strapsToReturn.addAll(distinctStrapsToReturn);
        return strapsToReturn;
    }

    @Override
    public List<StrapDTO> findAll() {
        List<StrapDTO> straps = orikaBeanMapper.mapAsList(strapDAO.findAll(), StrapDTO.class);
        for(int i=0; i < straps.size(); i++ ){
            List<Light> lights = lightDAO.findAllByPersonId(straps.get(i).getPerson().getId());
            if(!lights.isEmpty()) {
                RoomDTO room = orikaBeanMapper.map(lights.get(0).getRoom(), RoomDTO.class);
                System.out.println(room.getNum());
                straps.get(i).setRoom(room);
            }
        }
        return straps;
    }

    @Override
    public StrapDTO save(StrapDTO sdto) {
        Strap s = orikaBeanMapper.map(sdto, Strap.class);
        return orikaBeanMapper.map(strapDAO.save(s), StrapDTO.class);
    }

    private float calculateTimeOnLastMonth(List<StrapHistoric> strapHistorics) {
        LocalDate d = LocalDate.now().minusMonths(1); //Pick date one month ago
        float percentageOnLastMonth = 0;
        if (strapHistorics != null && !strapHistorics.isEmpty()) { //verify that historic for the iot exist
            int timeOn = 0;
            int timeOff = 0;
            for (StrapHistoric strapHistoric : strapHistorics) {
                if ((Instant.ofEpochMilli(strapHistoric.getStartDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) { //verify that we're just getting historic from the last month to today
                    //calculate time on and time off
                    if (strapHistoric.getState().equals(StateEnum.ON) || strapHistoric.getState().equals(StateEnum.STANDBY)) {
                        timeOn = timeOn + (int) (strapHistoric.getEndingDate().getTime() / 100000 - strapHistoric.getStartDate().getTime() / 100000);
                    } else if (strapHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (strapHistoric.getEndingDate().getTime() / 100000 - strapHistoric.getStartDate().getTime() / 100000);
                    }
                }
            }
            //calcultate time global when the heater was on last month (in percent)
            int totalTime = timeOn + timeOff;
            percentageOnLastMonth = ((float) timeOn / (float) totalTime) * 100;
        }
        return percentageOnLastMonth;
    }
    public StrapDTO findById(String id) {
        Strap strap = strapDAO.findById(Long.parseLong(id)).orElse(null);
        Light l = lightDAO.findAllByPersonId(strap.getPerson().getId()).get(0);
        StrapDTO strapDTO = orikaBeanMapper.map(strap, StrapDTO.class);
        RoomDTO room = orikaBeanMapper.map(l.getRoom(), RoomDTO.class);
        strapDTO.setRoom(room);
       return strapDTO;
    }
}

package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ShutterDAO;
import com.lifetech.domain.dao.ShutterHistoricDAO;
import com.lifetech.domain.model.Shutter;
import com.lifetech.domain.model.ShutterHistoric;
import com.lifetech.domain.model.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShutterManagerImpl implements ShutterManager {

    private static final Logger LOG = LoggerFactory.getLogger(ShutterManagerImpl.class);

    private final ShutterDAO shutterDAO;

    private final ShutterHistoricDAO shutterHistoricDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public ShutterManagerImpl(ShutterHistoricDAO shutterHistoricDAO, ShutterDAO shutterDAO, OrikaBeanMapper orikaBeanMapper) {
        this.shutterHistoricDAO = shutterHistoricDAO;
        this.shutterDAO = shutterDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }
    @Override
    public ShutterDTO findByRoom(String id) {
        return null;
    }

    @Override
    public ShutterDetailDTO findByHistoric(String id) {
        Shutter shutter = shutterDAO.findById(Long.parseLong(id)).orElse(null);
        ShutterDTO shutterDTO = orikaBeanMapper.map(shutter, ShutterDTO.class);
        List<ShutterHistoric> shutterHistorics = shutterHistoricDAO.findAllByShutterId(Long.parseLong(id));
        LocalDate d = LocalDate.now().minusMonths(1);
        String percentageLastMonth = null;
        if (shutterHistorics != null && !shutterHistorics.isEmpty()) {
            int timeOn = 0;
            int timeOff = 0;
            for (ShutterHistoric shutterHistoric : shutterHistorics) {
                if ((Instant.ofEpochMilli(shutterHistoric.getStartDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) {
                    if (shutterHistoric.getState().equals("on")) {
                        timeOn = timeOn + (int) (shutterHistoric.getEndingDate().getTime()/100000 - shutterHistoric.getStartDate().getTime()/100000);
                    } else if (shutterHistoric.getState().equals("off")) {
                        timeOff = timeOff + (int) (shutterHistoric.getEndingDate().getTime()/100000 - shutterHistoric.getStartDate().getTime()/100000);
                    }
                }
            }
            int totalTime = timeOn + timeOff;
            float percentageOnLastMonth = ((float)timeOn / (float)totalTime)*100;
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        ShutterDetailDTO shutterDetailDTO = new ShutterDetailDTO();
        shutterDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        shutterDetailDTO.setShutter(shutterDTO);
        return shutterDetailDTO;
    }

    @Override
    public List<Shutter> findAllShutterMalFunctionning() {
        List<Shutter> shutters = shutterDAO.findAll();
        List<ShutterHistoric> shutterHistorics = shutterHistoricDAO.findAll();
        List<Shutter> shuttersToReturn = new ArrayList<>();
        for(Shutter shutter: shutters){
            List<ShutterHistoric> historicToVerify= new ArrayList<>();
            for(ShutterHistoric shutterHistoric: shutterHistorics){
                if(shutterHistoric.getShutterId().equals(shutter.getId())){
                    historicToVerify.add(shutterHistoric);
                }
            }
            for(ShutterHistoric shutterHistoric: historicToVerify){
                if(shutterHistoric.getBreakdownstatus().equals(StatusEnum.BREAKDOWN)){
                    shuttersToReturn.add(shutter);
                }
            }
        }
        return shuttersToReturn;
    }
}

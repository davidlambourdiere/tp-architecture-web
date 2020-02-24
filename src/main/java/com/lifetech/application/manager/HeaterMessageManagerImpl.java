package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterMessageDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterBreakdownDAO;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterMessageDAO;
import com.lifetech.domain.factory.HeaterFactory;
import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterBreakdown;
import com.lifetech.domain.model.HeaterMessage;
import com.lifetech.domain.model.StatusEnum;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HeaterMessageManagerImpl implements HeaterMessageManager {
    final HeaterDAO heaterdao;
    final HeaterMessageDAO heatermessagedao;
    final HeaterBreakdownDAO heaterBreakdownDAO;
    private final OrikaBeanMapper orikaBeanMapper;

    public HeaterMessageManagerImpl(HeaterDAO heaterdao, HeaterMessageDAO heatermessagedao, HeaterBreakdownDAO heaterBreakdownDAO, OrikaBeanMapper orikaBeanMapper) {
        this.heaterdao = heaterdao;
        this.heatermessagedao = heatermessagedao;
        this.heaterBreakdownDAO = heaterBreakdownDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }



    @Override
    public List<HeaterMessageDTO> findAllByHeater(String id) {
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        List<HeaterMessage> messages = heatermessagedao.findAllByHeater(heater);
        return orikaBeanMapper.mapAsList(messages, HeaterMessageDTO.class);
    }


//    public HeaterMessageDTO findFirstByOrderByInsertDateDesc() {
//        HeaterMessage heaterMessage = heatermessagedao.findFirstByOrderByInsertDateDesc();
//       return orikaBeanMapper.map(heaterMessage, HeaterMessageDTO.class);
//    }



    @Override
    public boolean breakdownDetection(String id) {
        //HeaterMessageDTO heaterMessageDTO = this.findFirstByOrderByInsertDateDesc();
        List<HeaterMessageDTO> listHeaterMessageDTO = this.findAllByHeater(id);
        listHeaterMessageDTO.sort(Comparator.comparing(HeaterMessageDTO::getInsertDate));
        HeaterMessageDTO heaterMessageDTO = listHeaterMessageDTO.get(listHeaterMessageDTO.size() - 1);
        // algorith : breakdown detection for heater
        String temperature = heaterMessageDTO.getTemperatureMessage();
        System.out.println("temperature du message " + temperature);
        boolean breakdown = false;
        int temperatureInt = Integer.parseInt(temperature);
        if (temperatureInt > 50 || temperatureInt < -10) {
            breakdown = true;
            // inserting of new breakdown
            insertHeaterBreakdown(id, "YES", "NO", "Temperature suspecte !");
            // updating of heater's status --> BREAKDOWN
            updateHeaterStatus(id);
        } else {
            breakdown = false;
            updateHeaterStatusNoBreakdown(id);
        }
        return breakdown;
    }


    void insertHeaterBreakdown(String id, String suspect, String breakdown, String message){
        // creation of the current date + parse in String
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = Calendar.getInstance().getTime();
        String dateAsString = df.format(date);
        // The heater of the id
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        //HeaterBreakdownDTO heaterBreakdownDTO = new HeaterBreakdownDTO("1", dateAsString, "1970-01-01 00:00:00", "YES", "NO", "Temperature qui n'ont pas de sens", heaterMessageDTO.getHeater());
        HeaterBreakdown heaterBreakdown = new HeaterBreakdown("1", dateAsString, " ", suspect, breakdown, message, heater);
        System.out.println("je suis la panne à inserer " + heaterBreakdown);
        heaterBreakdownDAO.save(heaterBreakdown);
    }

    void updateHeaterStatus(String id) {
        // The heater of the id
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        // update of the status' heater --> BREAKDOWN
        heater.setBreakdownstatus(StatusEnum.BREAKDOWN);
        heaterdao.save(heater);
    }

    void updateHeaterStatusNoBreakdown(String id) {
        // The heater of the id
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        //update of the status' heater --> NOT_BREAKDOWN
        heater.setBreakdownstatus(StatusEnum.NOT_BREAKDOWN);
        heaterdao.save(heater);
    }
}

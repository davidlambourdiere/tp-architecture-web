package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.dto.HeaterMessageDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterBreakdownDAO;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterMessageDAO;
import com.lifetech.domain.factory.HeaterFactory;
import com.lifetech.domain.model.*;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
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


    @Override
    public boolean breakdownDetection(String id) {
        System.out.println("Panne - On s'occupe du radiateur numero " + id);
        List<HeaterMessageDTO> listHeaterMessageDTO = this.findAllByHeater(id);
        listHeaterMessageDTO.sort(Comparator.comparing(HeaterMessageDTO::getInsertDate));
        // The heater of the id
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        boolean breakdown = false;
        try {
            HeaterMessageDTO heaterMessageDTO = listHeaterMessageDTO.get(listHeaterMessageDTO.size() - 1);
            // algorith : breakdown detection for heater
            String state = heaterMessageDTO.getStateMessage();
            String on = StateEnum.ON.toString();
            // Getting date insert
            Date dateMessage = heaterMessageDTO.getInsertDate();
            // Creation date
            String pattern = "yyyy-MM-dd HH:mm:ss";
            Date date = new Date();
            // Difference between the two date
            long diff = date.getTime() - dateMessage.getTime();
            // if the heater is on but it was not send message for 25 minutes (= missing 5 messages)
            if (state.equals(on) && diff > 1200000 ) {
                breakdown = true;
                // inserting of new breakdown
                insertHeaterBreakdown(id, heater.getSuspect().toString(), "YES", "Plus de messages");
                // updating of heater's status --> BREAKDOWN
                updateHeaterStatus(heater);
            } else {
                breakdown = false;
                updateHeaterStatusNoBreakdown(heater);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Panne - Il n'y a pas de message pour le radiateur " + id);
        }
        return breakdown;
    }

    @Override
    public boolean suspectDetection(String id) {
        System.out.println("Suspect - On s'occupe du radiateur numero " + id);
        List<HeaterMessageDTO> listHeaterMessageDTO = this.findAllByHeater(id);
        listHeaterMessageDTO.sort(Comparator.comparing(HeaterMessageDTO::getInsertDate));
        // The heater of the id
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        boolean suspect = false;
        try {
            HeaterMessageDTO heaterMessageDTO = listHeaterMessageDTO.get(listHeaterMessageDTO.size() - 1);
            // algorith : suspect detection for heater
            String temperature = heaterMessageDTO.getTemperatureMessage();
            System.out.println("temperature du radiateur " + id + " : " + temperature);
            int temperatureInt = Integer.parseInt(temperature);
            if (temperatureInt > 50 || temperatureInt < -10) {
                suspect = true;
                // inserting of new breakdown
                insertHeaterBreakdown(id, "YES", heater.getBreakdownstatus().toString(), "Temperature suspecte !");
                // updating of heater's status --> BREAKDOWN
                updateHeaterSuspect(heater);
            } else {
                suspect = false;
                updateHeaterNoSuspect(heater);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Suspect - Il n'y a pas de message pour le radiateur " + id);
        }
        return suspect;
    }



    void insertHeaterBreakdown(String id, String suspect, String breakdown, String message) {
        // creation of the current date + parse in String
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = Calendar.getInstance().getTime();
        String dateAsString = df.format(date);
        // The heater of the id
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        HeaterBreakdown heaterBreakdown = new HeaterBreakdown("1", dateAsString, " ", suspect, breakdown, message, heater);
        System.out.println("je suis la panne à inserer - raditeur " + id + " - pour suspect : " + suspect + " - pour panne : " + breakdown );
        heaterBreakdownDAO.save(heaterBreakdown);
    }

    void updateHeaterStatus(Heater heater) {
        // update of the status' heater --> BREAKDOWN
        heater.setBreakdownstatus(StatusEnum.BREAKDOWN);
        heaterdao.save(heater);
    }

    void updateHeaterStatusNoBreakdown(Heater heater) {
        //update of the status' heater --> NOT_BREAKDOWN
        heater.setBreakdownstatus(StatusEnum.NOT_BREAKDOWN);
        heaterdao.save(heater);
    }

    void updateHeaterSuspect(Heater heater) {
        // update of the status' heater --> SUSPECT
        heater.setSuspect(SuspectEnum.SUSPECT);
        heaterdao.save(heater);
    }

    void updateHeaterNoSuspect(Heater heater) {
        //update of the status' heater --> NOT_SUSPECT
        heater.setSuspect(SuspectEnum.NOT_SUSPECT);
        heaterdao.save(heater);
    }
}

package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterBreakdownDTO;
import com.lifetech.application.dto.HeaterMessageDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterMessageDAO;
import com.lifetech.domain.factory.HeaterBreakdownFactoryImpl;
import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterMessage;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class HeaterMessageManagerImpl implements HeaterMessageManager {
    final HeaterDAO heaterdao;
    final HeaterMessageDAO heatermessagedao;
    private final OrikaBeanMapper orikaBeanMapper;

    public HeaterMessageManagerImpl(HeaterDAO heaterdao, HeaterMessageDAO heatermessagedao, OrikaBeanMapper orikaBeanMapper) {
        this.heaterdao = heaterdao;
        this.heatermessagedao = heatermessagedao;
        this.orikaBeanMapper = orikaBeanMapper;
    }


    @Override
    public List<HeaterMessageDTO> findHeaterMessageByHeater(String id) {
        Heater heater = heaterdao.findById(Long.parseLong(id)).orElse(null);
        List<HeaterMessage> messages = heatermessagedao.findHeaterMessageByHeater(heater);
        return orikaBeanMapper.mapAsList(messages, HeaterMessageDTO.class);
    }

    //@Override
    //public HeaterMessageDTO findFirstByOrderByInsertDateDesc() {
    //    HeaterMessage heaterMessage = heatermessagedao.findFirstByOrderByInsertDateDesc();
    //   return orikaBeanMapper.map(heaterMessage, HeaterMessageDTO.class);
    //}

    @Override
    public boolean breakdownDetection() {
        HeaterMessage heaterMessage = heatermessagedao.findFirstByOrderByInsertDateDesc();
        HeaterMessageDTO heaterMessageDTO = orikaBeanMapper.map(heaterMessage, HeaterMessageDTO.class);
        String temperature = heaterMessage.getTemperatureMessage();
        boolean breakdown = false;
        if (Integer.parseInt(temperature) > 50 && Integer.parseInt(temperature) < -10) {
            // creation of the current date + parse in String
            String pattern = "MM/dd/yyyy HH:mm:ss";
            DateFormat df = new SimpleDateFormat(pattern);
            Date date = Calendar.getInstance().getTime();
            String dateAsString = df.format(date);
            // New Breakdown : the conduct of the heater is suspect
            breakdown = true;
            HeaterBreakdownDTO heaterBreakdownDTO = new HeaterBreakdownDTO("1", dateAsString, "1970-01-01 00:00:00", "YES", "NO", "Temperature qui n'ont pas de sens", heaterMessage.getHeater());
        }
        return breakdown;
    }
}

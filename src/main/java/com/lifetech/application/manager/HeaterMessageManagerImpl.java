package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterMessageDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterMessageDAO;
import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterMessage;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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

//    @Override
//    public HeaterMessageDTO findLastHeaterMessage() {
//        //HeaterMessage heaterMessage = heatermessagedao.findFirstByOrderByInsertDateIdDesc();
//        return orikaBeanMapper.map(heaterMessage, HeaterMessageDTO.class);
//    }
}

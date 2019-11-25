package com.lifetech.application.manager;

import com.lifetech.application.dto.IOTDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.IOTDAO;
import com.lifetech.domain.model.IOT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOTManagerImpl implements IOTManager{

    private final IOTDAO iotdao;

    private final OrikaBeanMapper orikaBeanMapper;

    public IOTManagerImpl(IOTDAO iotdao, OrikaBeanMapper orikaBeanMapper) {
        this.iotdao = iotdao;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    public List<IOTDTO> findAllIOT(){
        List<IOT> iots = iotdao.findAll();
        return orikaBeanMapper.mapAsList(iots, IOTDTO.class);
    }
}

package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ShutterDAO;
import com.lifetech.domain.dao.ShutterHistoricDAO;
import com.lifetech.domain.model.Shutter;
import com.lifetech.domain.model.ShutterHistoric;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShutterManagerImpl implements ShutterManager {

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
        ShutterDetailDTO shutterDetailDTO = new ShutterDetailDTO();
        shutterDetailDTO.setShutter(shutterDTO);
        return shutterDetailDTO;
    }
}

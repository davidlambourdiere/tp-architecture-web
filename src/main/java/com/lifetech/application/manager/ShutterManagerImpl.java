package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ShutterDAO;
import com.lifetech.domain.model.Shutter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShutterManagerImpl implements ShutterManager {

    private final ShutterDAO shutterDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public ShutterManagerImpl(ShutterDAO shutterDAO, OrikaBeanMapper orikaBeanMapper) {
        this.shutterDAO = shutterDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }
    @Override
    public ShutterDTO findByRoom(String id) {
        return null;
    }

    public List<ShutterDTO> findAllShutter(){
        List<Shutter> shutters = shutterDAO.findAll();
        return orikaBeanMapper.mapAsList(shutters, ShutterDTO.class);
    }

    @Override
    public ShutterDTO findById(String id) {
        Shutter shutter = shutterDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(shutter, ShutterDTO.class);
    }

    public List<ShutterDTO> findShutterByPerson(String id) {
        List<Shutter> shutters = shutterDAO.findAllByPersonId(Long. parseLong(id));
        return orikaBeanMapper.mapAsList(shutters, ShutterDTO.class);
    }


    @Override
    public ShutterDetailDTO findByHistoric(String id) {
        Shutter shutter = shutterDAO.findById(Long.parseLong(id)).orElse(null);
        ShutterDTO shutterDTO = orikaBeanMapper.map(shutter, ShutterDTO.class);
        ShutterDetailDTO shutterDetailDTO = new ShutterDetailDTO();
        shutterDetailDTO.setShutter(shutterDTO);
        return shutterDetailDTO;
    }



    @Override
    public ShutterDTO updateShutter(String id, ShutterDTO shutterDtoReceived) {

        Shutter shutter = shutterDAO.findById(Long.parseLong(id)).orElse(null);
        // converti en DTO pour modifier
        ShutterDTO updatedShutterDTO = orikaBeanMapper.map(shutter, ShutterDTO.class);

        updatedShutterDTO.setPercentage(shutterDtoReceived.getPercentage());
        Shutter shuttersaved = orikaBeanMapper.map(updatedShutterDTO, Shutter.class);
        System.out.println(shuttersaved);
        return orikaBeanMapper.map(shutterDAO.save(shuttersaved), ShutterDTO.class);
    }
}

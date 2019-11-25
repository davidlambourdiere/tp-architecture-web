package com.lifetech.application.manager;

import com.lifetech.application.dto.ObjectDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ObjectDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectManagerImpl implements ObjectManager {

    private final ObjectDAO objectDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public ObjectManagerImpl(OrikaBeanMapper orikaBeanMapper, ObjectDAO objectDAO) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.objectDAO = objectDAO;
    }

    @Override
    public List<ObjectDTO> findAll() {
        return orikaBeanMapper.mapAsList(objectDAO.findAll(), ObjectDTO.class);
    }
}

package com.demospringboot.application.manager;

import com.demospringboot.application.dto.ObjectDTO;
import com.demospringboot.domain.OrikaBeanMapper;
import com.demospringboot.domain.dao.ObjectDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectManagerImpl implements ObjectManager{

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

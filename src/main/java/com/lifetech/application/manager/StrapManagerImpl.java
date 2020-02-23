package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapDTO;
import com.lifetech.application.dto.StrapDetailDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.StrapDAO;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Strap;
import org.springframework.stereotype.Service;

@Service
public class StrapManagerImpl implements StrapManager {


    private final StrapDAO strapDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public StrapManagerImpl(StrapDAO strapDAO, OrikaBeanMapper orikaBeanMapper) {
        this.strapDAO = strapDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }
    @Override
    public StrapDetailDTO findByHistoric(String id) {
        Strap strap = strapDAO.findById(Long.parseLong(id)).orElse(null);
        StrapDTO strapDTO = orikaBeanMapper.map(strap, StrapDTO.class);
        StrapDetailDTO strapDetailDTO = new StrapDetailDTO();
        strapDetailDTO.setStrap(strapDTO);
        return strapDetailDTO;
    }

    @Override
    public StrapDTO findById(String id) {
        Strap strap= strapDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(strap, StrapDTO.class);
    }
}

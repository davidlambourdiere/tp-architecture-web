package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapDTO;
import com.lifetech.application.dto.StrapDetailDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.StrapDAO;
import com.lifetech.domain.dao.StrapHistoricDAO;
import com.lifetech.domain.model.Strap;
import com.lifetech.domain.model.StrapHistoric;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrapManagerImpl implements StrapManager {


    private final StrapDAO strapDAO;

    private final StrapHistoricDAO strapHistoricDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public StrapManagerImpl(StrapHistoricDAO strapHistoricDAO, StrapDAO strapDAO, OrikaBeanMapper orikaBeanMapper) {
        this.strapHistoricDAO = strapHistoricDAO;
        this.strapDAO = strapDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }
    @Override
    public StrapDetailDTO findByHistoric(String id) {
        Strap strap = strapDAO.findById(Long.parseLong(id)).orElse(null);
        StrapDTO strapDTO = orikaBeanMapper.map(strap, StrapDTO.class);
        List<StrapHistoric> strapHistorics = strapHistoricDAO.findAllByStrapId(Long.parseLong(id));
        StrapDetailDTO strapDetailDTO = new StrapDetailDTO();
        strapDetailDTO.setStrap(strapDTO);
        return strapDetailDTO;
    }
}

package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapDTO;
import com.lifetech.application.dto.StrapDetailDTO;
import com.lifetech.domain.model.Strap;

import java.util.List;

public interface StrapManager {
    StrapDetailDTO findByHistoric(String id);

    StrapDTO findById(String id);

    List<Strap> findAllStrapMalFunctionning();

    List<StrapDTO> findAll();

    StrapDTO save(StrapDTO sdto);

    Strap findModelById(String strap);

    Strap save(Strap strap);
}

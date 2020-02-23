package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapDTO;
import com.lifetech.application.dto.StrapDetailDTO;

public interface StrapManager {
    StrapDetailDTO findByHistoric(String id);

    StrapDTO findById(String id);
}

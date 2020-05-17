package com.lifetech.application.manager;


import com.lifetech.application.dto.HeaterMessageDTO;

import java.util.List;

public interface HeaterMessageManager {
    List<HeaterMessageDTO> findAllByHeater (String id);

    boolean breakdownDetection(String id);

    boolean suspectDetection(String id);



}

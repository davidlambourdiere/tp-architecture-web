package com.lifetech.application.manager;


import com.lifetech.application.dto.HeaterMessageDTO;

import java.util.List;

public interface HeaterMessageManager {
    List<HeaterMessageDTO> findHeaterMessageByHeater (String id);

    HeaterMessageDTO findLastHeaterMessage();
}

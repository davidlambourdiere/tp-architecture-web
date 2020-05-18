package com.lifetech.application.manager;

import com.lifetech.application.dto.ClockDTO;
import com.lifetech.application.dto.ClockDetailDTO;
import com.lifetech.domain.model.Clock;
import com.lifetech.domain.model.Room;

import java.util.List;

public interface ClockManager {
    ClockDTO findById(String id);

    List<ClockDTO> findByRoom(String id);

    ClockDetailDTO findByHistoric(String id);

    ClockDTO updateClock( String id, ClockDTO clockDtoReceived);

    List<Clock> findAllClockMalFunctionning();
}

package com.lifetech.application.manager;

import TrackerResident.Coordinate;
import com.lifetech.application.dto.PositionDTO;
import com.lifetech.domain.model.Position;
import com.lifetech.domain.model.Strap;

import java.util.*;

public interface PositionManager {
    PositionDTO findPositionByStrap(long strapId);

    public void simulatePosition (Strap strap) throws Exception;

    public List<PositionDTO> positionHistory(long strpId);

    public void insertPositionRunnerStrap(String status);
}

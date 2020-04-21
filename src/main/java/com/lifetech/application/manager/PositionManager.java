package com.lifetech.application.manager;

import com.lifetech.application.dto.PositionDTO;
import java.util.List;

public interface PositionManager {
    PositionDTO findPositionByStrap(long strapId);
}

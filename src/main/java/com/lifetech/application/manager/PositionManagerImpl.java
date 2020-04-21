package com.lifetech.application.manager;

import com.lifetech.application.dto.PositionDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PositionDAO;
import com.lifetech.domain.model.Position;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.CookieThemeResolver;

@Service
public class PositionManagerImpl implements PositionManager{
    private final PositionDAO positionDAO;
    private final OrikaBeanMapper orikaBeanMapper;

    public PositionManagerImpl(PositionDAO positionDAO, OrikaBeanMapper orikaBeanMapper) {
        this.positionDAO = positionDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public PositionDTO findPositionByStrap(long strapId) {
        Position p = positionDAO.findPositionByStrap(strapId);
        return orikaBeanMapper.map(p, PositionDTO.class);
    }
}

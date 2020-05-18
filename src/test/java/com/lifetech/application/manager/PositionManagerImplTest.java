package com.lifetech.application.manager;

import com.lifetech.application.dto.PositionDTO;
import com.lifetech.application.dto.StrapDTO;
import com.lifetech.domain.dao.PositionDAO;
import com.lifetech.domain.model.Position;
import com.lifetech.domain.model.Strap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Classe de test pour les manger Position
 */
@RunWith(MockitoJUnitRunner.class)
public class PositionManagerImplTest {
    /**
     * Mock pour Position Manager Impl
     */
    @Mock
    private PositionManagerImpl positionManager;

    /**
     * Mock pour Position Dao
     */
    @Mock
    private PositionDAO positionDAO;

    /**
     * Initialiser les mock
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Methode pour tester la récupération de la position d'un bracelet
     */
    @Test
    public void findPositionByStrapIdTest() {
        Strap strap = new Strap();
        strap.setId(1L);
        StrapDTO strapDTO = new StrapDTO();
        strapDTO.setId(1L);
        Position p = new Position(new Date(), 4.12345672, 46.43556657);
        p.setId(1L);
        p.setStrap(strap);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setDate(new Date());
        positionDTO.setLatitude(p.getLatitude());
        positionDTO.setLongitude(p.getLongitude());
        positionDTO.setStrap(strapDTO);
        positionDTO.setId(strapDTO.getId());
        when(positionDAO.findPositionByStrap(strap.getId())).thenReturn(p);
        when(positionManager.findPositionByStrap(strap.getId())).thenReturn(positionDTO);
        PositionDTO pDto = this.positionManager.findPositionByStrap(strap.getId());
        Position pos = this.positionDAO.findPositionByStrap(strap.getId());
        Assert.assertEquals(pDto.getId(), pos.getId());
    }

    /**
     * Test de récupération de l'historique de position d'un bracelet
     */
    @Test
    public void positionHistoryTest(){
        StrapDTO strap = new StrapDTO();
        strap.setId(1L);
        PositionDTO positionDTO1 = new PositionDTO(new Date(), 2.234556, 46.764556, strap);
        PositionDTO positionDTO2 = new PositionDTO(new Date(), 2.43566, 46.87653, strap);;
        PositionDTO positionDTO3 = new PositionDTO(new Date(), 2.456789, 46.787976, strap);;
        List<PositionDTO>  positionDTOs = new ArrayList<>();
        positionDTOs.add(positionDTO1);
        positionDTOs.add(positionDTO2);
        positionDTOs.add(positionDTO3);
        when(positionManager.positionHistory(strap.getId())).thenReturn(positionDTOs);
        List<PositionDTO> positionDTOList = positionManager.positionHistory(strap.getId());
        Assert.assertEquals(positionDTOs.size() , positionDTOList.size());
    }
}

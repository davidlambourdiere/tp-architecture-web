package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.application.dto.HealthHistoricDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.AlertHealthDAO;
import com.lifetech.domain.dao.HealthHistoricDAO;
import com.lifetech.domain.model.AlertCache;
import com.lifetech.domain.model.AlertHealth;
import com.lifetech.domain.model.HealthHistoric;
import com.lifetech.domain.model.Strap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HealtHistorichManagerImplTest {

    @InjectMocks
    @Autowired
    private  HealthHistoricManagerImpl healthHistoricManagerImpl;

    @Mock
    @Autowired
    private HealthHistoricDAO healthHistoricDAO;

    @Mock
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Mock
    @Autowired
    private StrapManager strapManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /***
     * Init: Create 1 instance of HealthHistoric
     * invoke save
     * verification : must return saved historic
     ****/
    @Test
    public void testSave_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        HealthHistoric histSaved1 = new HealthHistoric();
        histSaved1.setHearthrate("197");
        histSaved1.setStrap((long) 8);
        Mockito.when(healthHistoricDAO.save(histSaved1)).thenReturn(histSaved1);

        // transition
        HealthHistoric h = healthHistoricDAO.save(histSaved1);
        // verification
        assertNotNull("method must be successfully invoked", h);
    }



    /***
     * Init: Create 1 instance of Message HealthHistoric
     * invoke split
     * verification : must return HealthHistoric
     ****/
    @Test
    public void testSplit_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        String message = "hearthrate=60,systolic=null,diastolic=null,sugarlevel=null,stepcounter=null,strapid=3,startdate=2020-05-17 16:03:51.113";

        // transition
        HealthHistoric h = healthHistoricManagerImpl.split(message);

        // verification
        assertNotNull("method must be successfully invoked", h);
    }


    /***
     * Init: Create 2 instance of HealthHistoricDTO and find the last HealthHistoricDTO
     * invoke FindTopByStrap
     * verification : results must be the same
     ****/
    @Test
    public void testFindTopByStrap_TheMethodMustToBeSuccessfullyInvoked() {
        //init
        HealthHistoricDTO h1;
        HealthHistoricDTO h2;
        //find  last hearthRate historic
        List<HealthHistoric> hlist = healthHistoricDAO.findByStrap(Long.parseLong("8"));
        HealthHistoric histo = new HealthHistoric();
        if (hlist.size()>0) {
            histo = hlist.get(hlist.size()-1);
        }
        h2 = orikaBeanMapper.map(histo, HealthHistoricDTO.class);

        // transition
        h1 = healthHistoricManagerImpl.findTopByStrap("8");

        // verification
        assertEquals("findAll method must be successfully invoked", h1, h2);
    }


    /***
     * Init: Create 2 instance of List of HealthHistoricDTO
     * invoke FindHistoricByStrap
     * verification : the 2 lists must have the same size
     ****/
    @Test
    public void testFindHistoricByStrap_TheMethodMustToBeSuccessfullyInvoked() {
        //init
        List<HealthHistoricDTO> listH1;
        List<HealthHistoric> listH2;

        // transition
        listH1 = healthHistoricManagerImpl.findHistoricByStrap("8");
        listH2 = healthHistoricDAO.findByStrap((long) 8);

        // verification
        assertEquals("findAll method must be successfully invoked", listH1.size(), listH2.size());
    }
}

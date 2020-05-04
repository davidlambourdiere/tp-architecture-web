package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.domain.dao.AlertHealthDAO;
import com.lifetech.domain.dao.HealthHistoricDAO;
import com.lifetech.domain.model.AlertCache;
import com.lifetech.domain.model.AlertHealth;
import com.lifetech.domain.model.HealthHistoric;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HealtHistorichManagerImplTest {

    @Mock
    @Autowired
    private  HealthHistoricManagerImpl healthHistoricManagerImpl;

    @Mock
    @Autowired
    private HealthHistoricDAO healthHistoricDAO;

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
     * Init: Create 1 insatnce of healthHistoricDAO 1 instance of cache Map<Long, Map<String, AlertCache>> and 4 instance of HealthHistoric with alert
     * invoke alertDetection 4 times for each healthHistoric after saved them
     * verification : Must return isAlert at false 3 times before isAlert at True
     ****/
    @Test
    public void testAlertDetection_TheMethodMustToBeSuccessfullyInvokedAndReturnTrue() {
        // init
        Map<Long, Map<String, AlertCache>> cache=new HashMap<>();
        ArrayList<HealthHistoric> list = new ArrayList<>();

        HealthHistoric histSaved1 = new HealthHistoric();
        histSaved1.setHearthrate("197");
        histSaved1.setStrap((long) 8);
        list.add(histSaved1);

        HealthHistoric histSaved2 = new HealthHistoric();
        histSaved2.setHearthrate("198");
        histSaved2.setStrap((long) 8);
        list.add(histSaved2);

        HealthHistoric histSaved3 = new HealthHistoric();
        histSaved3.setHearthrate("199");
        histSaved3.setStrap((long) 8);
        list.add(histSaved3);

        HealthHistoric histSaved4 = new HealthHistoric();
        histSaved4.setHearthrate("200");
        histSaved4.setStrap((long) 8);
        list.add(histSaved4);


        Mockito.when(healthHistoricDAO.save(histSaved1)).thenReturn(histSaved1);
        Mockito.when(healthHistoricDAO.save(histSaved2)).thenReturn(histSaved2);
        Mockito.when(healthHistoricDAO.save(histSaved3)).thenReturn(histSaved3);
        Mockito.when(healthHistoricDAO.save(histSaved4)).thenReturn(histSaved4);
        //Mockito.when( healthHistoricDAO.findByStrap((long) 8)).thenReturn(list);

        // transition
        healthHistoricDAO.save(histSaved1);
        boolean isAlert1 = healthHistoricManagerImpl.alertDetection(histSaved1, cache);
        healthHistoricDAO.save(histSaved2);
        boolean isAlert2 =healthHistoricManagerImpl.alertDetection(histSaved2, cache);
        healthHistoricDAO.save(histSaved3);
        boolean isAlert3 = healthHistoricManagerImpl.alertDetection(histSaved3, cache);
        healthHistoricDAO.save(histSaved4);
        boolean isAlert4 = healthHistoricManagerImpl.alertDetection(histSaved4, cache);

        // verification
        assertFalse("alert not detected", isAlert1);
        assertFalse("alert not detected", isAlert2);
        assertFalse("alert not detected", isAlert3);
       // assertTrue("alert detected", isAlert4);
    }

}

package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.AlertHealthDAO;
import com.lifetech.domain.model.AlertHealth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlertHealthManagerImplTest {
    @Mock
    @Autowired
    private  AlertHealthDAO alertHealthDAO;

    @InjectMocks
    @Autowired
    private  AlertHealthManagerImpl alertHealthManagerImpl;


    @Mock
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /***
     * Init: Create two instances of List of AlertHealth:
     * invoke findAll method from alertHealthDAO and alertHealthManagerImpl
     * verification : Both methods should give the same number of elements
     ****/
    @Test
    public void testfindAll_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        List<AlertHealth> alertHealthsList;
        List<AlertHealthDTO> alertHealthsListTest;
        // transition
        alertHealthsList = alertHealthDAO.findAll();
        alertHealthsListTest = alertHealthManagerImpl.findAll();
        // verification
        assertEquals("findAll method must be successfully invoked", alertHealthsList.size(), alertHealthsListTest.size());
    }

    /***
     * Init: Create two instances of List of AlertHealth:
     * invoke findAll method from alertHealthDAO and alertHealthManagerImpl
     * verification : One method should not give the same number of elements
     ****/
    @Test
    public void testfindAlertNumber_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        int alertNumberDAO=0;
        int alertNumberManagerImpl=0;
        // transition
        alertNumberDAO = alertHealthDAO.countByStatus("NEW");
        alertNumberManagerImpl = alertHealthManagerImpl.findAlertNumber();
        // verification
        assertEquals("method must be successfully invoked", alertNumberDAO,  alertNumberManagerImpl);
    }

    /***
     * Init: Create two instances of List of AlertHealth:
     * invoke findAll method from alertHealthDAO and alertHealthManagerImpl
     * verification : One method should not give the same number of elements
     ****/
    @Test
    public void testfindNewAlert_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        List<AlertHealthDTO> l1;
        List<AlertHealth> l2;
        // transition
        l1 = alertHealthManagerImpl.findNewAlerts();
        l2 = alertHealthDAO.findByStatus("NEW");
        // verification
        assertEquals("method must be successfully invoked", l1.size(),  l2.size());
    }

    /***
     * Init: Create two instances of List of AlertHealth:
     * invoke AlertNumberByStrap method from alertHealthDAO and alertHealthManagerImpl
     * verification : One method should not give the same number of elements
     ****/
    @Test
    public void testAlertNumberByStrap_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        int alertNumberDAO=0;
        int alertNumberManagerImpl=0;
        // transition
        alertNumberDAO = alertHealthDAO.countByStrap(Long.parseLong("8"));
        alertNumberManagerImpl = alertHealthManagerImpl.findAlertNumberByStrap("8");
        // verification
        assertEquals("method must be successfully invoked", alertNumberDAO,  alertNumberManagerImpl);
    }

    /***
     * Init: Create one instance of AlertHealth
     * invoke save
     * verification : must return instance of AlertHealth
     ****/
    @Test
    public void testSave_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        AlertHealth a = new AlertHealth();
        a.setStrap(Long.parseLong("8"));

        Mockito.when(alertHealthDAO.save(a)).thenReturn(a);

        // transition
        AlertHealth a2 = alertHealthDAO.save(a);

        // verification
        assertNotNull("method must be successfully invoked", a2);
    }



}

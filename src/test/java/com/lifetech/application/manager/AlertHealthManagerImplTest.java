package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.domain.dao.AlertHealthDAO;
import com.lifetech.domain.model.AlertHealth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlertHealthManagerImplTest {
    @Mock
    @Autowired
    private  AlertHealthDAO alertHealthDAO;

    @Mock
    @Autowired
    private  AlertHealthManagerImpl alertHealthManagerImpl;


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
}

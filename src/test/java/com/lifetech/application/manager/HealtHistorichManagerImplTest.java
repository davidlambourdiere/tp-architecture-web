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


}

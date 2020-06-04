package com.lifetech.application.manager;

import com.lifetech.application.dto.ActivityAnalysisDTO;
import com.lifetech.domain.dao.*;
import com.lifetech.domain.model.Residence;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//@PropertySource("classpath:application-test.properties ")
@RunWith(MockitoJUnitRunner.class)
public class ActivityAnalysisManagerImplTest {

    @InjectMocks
    @Autowired
    private ActivityAnalysisManagerImpl activityAnalysisManager;

    @Mock
    @Autowired
    private HeaterBreakdownDAO heaterBreakdownDAO;
    @Mock
    private HeaterDAO heaterDAO;
    @Mock
    private ClockDAO clockDAO;
    @Mock
    private LightDAO lightDAO;
    @Mock
    private StrapDAO strapDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testpostAnalysisOnAllResidences_MustReturnAValidDTO(){
        //Initialization
        ActivityAnalysisDTO dto = new ActivityAnalysisDTO();
        dto.setResidenceid("0");
        dto.setPersonid("0");
        dto.setPeriod("all");

        Mockito.when(heaterBreakdownDAO.getBreakdownRate()).thenReturn("10");
        Mockito.when(heaterDAO.count()).thenReturn(1L);
        Mockito.when(clockDAO.count()).thenReturn(1L);
        Mockito.when(lightDAO.count()).thenReturn(1L);
        Mockito.when(strapDAO.count()).thenReturn(1L);

        ActivityAnalysisDTO expecteddto = new ActivityAnalysisDTO("0", "0", "all", null, null, "10", null, null, null, "1", "1", "1", "1");
        //Transition
        ActivityAnalysisDTO outputdto = activityAnalysisManager.postAnalysis(dto);

        //Verification
        assertEquals(expecteddto,outputdto);
    }
    @Test
    public void testpostAnalysisOnAllResidencesWithGivenPeriod_MustReturnAValidDTO(){
        //Initialization
        ActivityAnalysisDTO dto = new ActivityAnalysisDTO();
        dto.setResidenceid("0");
        dto.setPersonid("0");
        dto.setPeriod("given");
        dto.setStartdate("2020-10-09");
        dto.setEnddate("2020-10-10");
        Mockito.when(heaterBreakdownDAO.getBreakdownRateBetween("2020-10-09", "2020-10-10")).thenReturn("10");
        Mockito.when(heaterDAO.count()).thenReturn(1L);
        Mockito.when(clockDAO.count()).thenReturn(1L);
        Mockito.when(lightDAO.count()).thenReturn(1L);
        Mockito.when(strapDAO.count()).thenReturn(1L);

        ActivityAnalysisDTO expecteddto = new ActivityAnalysisDTO("0", "0", "given", "2020-10-09", "2020-10-10", "10", null, null, null, "1", "1", "1", "1");
        //Transition
        ActivityAnalysisDTO outputdto = activityAnalysisManager.postAnalysis(dto);

        //Verification
        assertEquals(expecteddto,outputdto);
    }
    @Test
    public void testpostAnalysisOnAnUniqueResidence_MustReturnAValidDTO(){
        //Initialization
        ActivityAnalysisDTO dto = new ActivityAnalysisDTO();
        dto.setResidenceid("1");
        dto.setPersonid("0");
        dto.setPeriod("all");

        Mockito.when(heaterBreakdownDAO.getBreakdownRateByResidence("1")).thenReturn("10");
        Mockito.when(heaterDAO.countByResidenceId("1")).thenReturn("1");
        Mockito.when(clockDAO.countByResidenceId("1")).thenReturn("1");
        Mockito.when(lightDAO.countByResidenceId("1")).thenReturn("1");
        Mockito.when(strapDAO.countByResidenceId("1")).thenReturn("1");

        ActivityAnalysisDTO expecteddto = new ActivityAnalysisDTO("1", "0", "all", null, null, "10", null, null, null, "1", "1", "1", "1");
        //Transition
        ActivityAnalysisDTO outputdto = activityAnalysisManager.postAnalysis(dto);

        //Verification
        assertEquals(expecteddto,outputdto);
    }
    @Test
    public void testpostAnalysisOnAnUniqueResidenceWithGivenPeriod_MustReturnAValidDTO(){
        //Initialization
        ActivityAnalysisDTO dto = new ActivityAnalysisDTO();
        dto.setResidenceid("1");
        dto.setPersonid("0");
        dto.setPeriod("given");
        dto.setStartdate("2020-10-09");
        dto.setEnddate("2020-10-10");

        Mockito.when(heaterBreakdownDAO.getHeaterBreakdownRateByResidenceBetween("1","2020-10-09","2020-10-10")).thenReturn("10");
        Mockito.when(heaterDAO.countByResidenceId("1")).thenReturn("1");
        Mockito.when(clockDAO.countByResidenceId("1")).thenReturn("1");
        Mockito.when(lightDAO.countByResidenceId("1")).thenReturn("1");
        Mockito.when(strapDAO.countByResidenceId("1")).thenReturn("1");

        ActivityAnalysisDTO expecteddto = new ActivityAnalysisDTO("1", "0", "given","2020-10-09","2020-10-10", "10", null, null, null, "1", "1", "1", "1");
        //Transition
        ActivityAnalysisDTO outputdto = activityAnalysisManager.postAnalysis(dto);

        //Verification
        assertEquals(expecteddto,outputdto);
    }
    @Test
    public void testpostAnalysisOnAnUniquePerson_MustReturnAValidDTO(){
        //Initialization
        ActivityAnalysisDTO dto = new ActivityAnalysisDTO();
        dto.setResidenceid("1");
        dto.setPersonid("1");
        dto.setPeriod("all");

        Mockito.when(heaterBreakdownDAO.getBreakdownRateByPerson("1")).thenReturn("10");
        Mockito.when(heaterDAO.countByPersonId("1")).thenReturn("1");
        Mockito.when(clockDAO.countByPersonId("1")).thenReturn("1");
        Mockito.when(lightDAO.countByPersonId("1")).thenReturn("1");
        Mockito.when(strapDAO.countByPersonId("1")).thenReturn("1");

        ActivityAnalysisDTO expecteddto = new ActivityAnalysisDTO("1", "1", "all", null, null, "10", null, null, null, "1", "1", "1", "1");
        //Transition
        ActivityAnalysisDTO outputdto = activityAnalysisManager.postAnalysis(dto);

        //Verification
        assertEquals(expecteddto,outputdto);
    }
    @Test
    public void testpostAnalysisOnAnUniquePersonWithGivenPeriod_MustReturnAValidDTO(){
        //Initialization
        ActivityAnalysisDTO dto = new ActivityAnalysisDTO();
        dto.setResidenceid("1");
        dto.setPersonid("1");
        dto.setPeriod("given");
        dto.setStartdate("2020-10-09");
        dto.setEnddate("2020-10-10");

        Mockito.when(heaterBreakdownDAO.getHeaterBreakdownRateByPersonBetween("1","2020-10-09","2020-10-10")).thenReturn("10");
        Mockito.when(heaterDAO.countByPersonId("1")).thenReturn("1");
        Mockito.when(clockDAO.countByPersonId("1")).thenReturn("1");
        Mockito.when(lightDAO.countByPersonId("1")).thenReturn("1");
        Mockito.when(strapDAO.countByPersonId("1")).thenReturn("1");

        ActivityAnalysisDTO expecteddto = new ActivityAnalysisDTO("1", "1", "given","2020-10-09","2020-10-10", "10", null, null, null, "1", "1", "1", "1");
        //Transition
        ActivityAnalysisDTO outputdto = activityAnalysisManager.postAnalysis(dto);

        //Verification
        assertEquals(expecteddto,outputdto);
    }
}

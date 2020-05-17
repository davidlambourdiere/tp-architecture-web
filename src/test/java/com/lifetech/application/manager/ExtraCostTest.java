package com.lifetech.application.manager;



import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ExtraCostDAO;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.model.ExtraCost;
import com.lifetech.domain.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ExtraCostTest {
    private static final Logger LOG = LoggerFactory.getLogger(ExtraCostTest.class);

    @Mock
    private PersonDAO personDAO;

    @Mock
    private ExtraCostDAO extraCostDAO;

    @Spy
    private OrikaBeanMapper orikaBeanMapper;


    /***
     * Unit test to find the Extra Cost from the resident by his login
     * From Person repo and ExtraCost repo
     ****/
    @Test
    public void testfindExtraCostByLoginOfPerson_TheMethodMustToBeSuccessfullyInvoked() {
        //Initiating
        Person person = new Person(null,null,null,null,null,null,
                null,"momo",null,null,null,
                null,null,null,null,null,
                null,null,null,null,null);

        ExtraCost extraCost = new ExtraCost(person, "BOUTEILLE DE EAU", 4.00, null);

        List<ExtraCost> extraCostList = new ArrayList<>();
        extraCostList.add(extraCost);

        Mockito.doReturn(person).when(personDAO).findByLogin(person.getLogin());
        Mockito.doReturn(extraCostList).when(extraCostDAO).findByPerson(person);

        //Transition
        List<ExtraCost> extraCOSTList = extraCostDAO.findByPerson(person);


        //Verify that list is not null
        assertNotNull(extraCOSTList);

        //Verify the size of the list is 1
        assertEquals(1,extraCOSTList.size());

        //Verify that the size must be different from 2 (should be 1)
        assertNotEquals(2,extraCOSTList.size());

    }

}

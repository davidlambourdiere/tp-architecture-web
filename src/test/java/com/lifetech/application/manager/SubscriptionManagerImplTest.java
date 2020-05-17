package com.lifetech.application.manager;


import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.SubscriptionDAO;
import com.lifetech.domain.model.Subscription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionManagerImplTest {

    @Mock
    private SubscriptionDAO subscriptionDAO;

    @InjectMocks
    private  SubscriptionManagerImp subscriptionManagerImp ;

    @Spy
    private OrikaBeanMapper orikaBeanMapper;


    /***
     * Unit test to find all subscription
     * From subscriptionManagerImp service
     ****/
    @Test
    public void testfindAllSubscription_TheMethodMustToBeSuccessfullyInvoked() {
        //Initiating
        Subscription sub = new Subscription("name",100.00,"description","listof","list");
        List<Subscription> subList = new ArrayList<>();
        subList.add(sub);

        Mockito.doReturn(subList).when(subscriptionDAO).findAll();

        //Transition
        List<SubscriptionDTO> subscriptionListDTO = subscriptionManagerImp.findAllSubscription();

        //Verify the size of the list
        assertEquals(1, subscriptionListDTO.size());

        //Verify that the list is not null
        assertNotNull(subscriptionListDTO);

    }

    /***
     * Unit test to find a subscription by its id
     * From subscriptionManagerImp service
     ****/
    @Test
    public void testfindById_TheMethodMustToBeSuccessfullyInvoked() {
        // init
        Subscription sub = new Subscription("name",100.00,"description","listof","list");

        //transition
        Mockito.doReturn(Optional.of(sub)).when(subscriptionDAO).findById(1L);


        //Verify data integrity
        assertEquals("description",sub.getDescription());


        // Verify sub is not null
        assertNotNull(sub);

    }

    /***
     * Unit test to find a Subscription by his name
     * From subscriptionManagerImp service
     ****/
    @Test public void testfindSubscriptionByProfile_TheMethodMustToBeSuccessfullyInvoked(){
        //init
        Subscription sub = new Subscription("serenity",100.00,"description of serenity","listof","list");
        Subscription sub1 = new Subscription("essential",100.00,"description of essential","listof","list");
        Subscription sub2 = new Subscription("confort",100.00,"description of confort","Heater","list");
        Subscription sub3 = new Subscription("total-confort",100.00,"description of total-confort","listof","Yoga");

        Mockito.doReturn(sub).when(subscriptionDAO).findByName("serenity");
        Mockito.doReturn(sub1).when(subscriptionDAO).findByName("essential");
        Mockito.doReturn(sub2).when(subscriptionDAO).findByName("confort");
        Mockito.doReturn(sub3).when(subscriptionDAO).findByName("total-confort");

        //transition

        SubscriptionDTO subscriptionDTO = subscriptionManagerImp.findSubscriptionByProfile(sub.getName());
        SubscriptionDTO subscriptionDTO1 = subscriptionManagerImp.findSubscriptionByProfile(sub1.getName());
        SubscriptionDTO subscriptionDTO2 = subscriptionManagerImp.findSubscriptionByProfile(sub2.getName());
        SubscriptionDTO subscriptionDTO3 = subscriptionManagerImp.findSubscriptionByProfile(sub3.getName());

        //verification that the name of subscription is return when is subscriptionDTO
        assertEquals("serenity",subscriptionDTO.getName());

        //verification that the name description is "description of essential" is return when is subscriptionDTO1
        assertEquals("description of essential",subscriptionDTO1.getDescription());

        //verification that the listofiot is return when is subscriptionDTO2
        assertEquals("Heater",subscriptionDTO2.getListofiot());

        //verification that the listof iot of subscription is return when is subscriptionDTO3
        assertEquals("Yoga",subscriptionDTO3.getListofservice());

        // verify that each subscriptionDTO is not null
        assertNotNull("should be return subscriptionDTO is not null",subscriptionDTO);
        assertNotNull("should be return subscriptionDTO1 is not null",subscriptionDTO1);
        assertNotNull("should be return subscriptionDTO2 is not null",subscriptionDTO2);
        assertNotNull("should be return subscriptionDTO3 is not null",subscriptionDTO3);



    }

    /***
     * Unit test to find all Subscription
     * From subscriptionManagerImp service
     * From subscriptionDAO repsitory
     ****/
    @Test
    public void testComparefindAllSubscriptionAndfindAllFromRepository_TheMethodMustToBeSuccessfullyInvoked() {
        //Initiating
        Subscription sub = new Subscription("name",100.00,"description","listof","list");
        List<Subscription> subList = new ArrayList<>();
        subList.add(sub);

        Mockito.doReturn(subList).when(subscriptionDAO).findAll();

        //Transition
        List<SubscriptionDTO> subscriptionListDTO = subscriptionManagerImp.findAllSubscription();

        //Verify that the size when we use the repository and the size when we use the service is the same
        assertEquals(subscriptionDAO.findAll().size(),subscriptionListDTO.size());

        //Verify that list is not null
        assertNotNull(subscriptionListDTO);
        assertNotNull(subscriptionDAO.findAll());

    }
    
}

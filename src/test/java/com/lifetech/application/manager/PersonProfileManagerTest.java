package com.lifetech.application.manager;
import com.lifetech.application.dto.PersonProfileDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonProfileDAO;
import com.lifetech.application.manager.PersonProfileManagerImpl;
import com.lifetech.domain.model.PersonProfile;
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
import org.junit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class PersonProfileManagerTest {

    private List<PersonProfileDTO> ListDTO;
    private PersonProfileDTO dto = new PersonProfileDTO();
    PersonProfileDTO profileDTO;

    @Mock
    private PersonProfileDAO personProfileDAO;

    @InjectMocks
    private  PersonProfileManagerImpl personProfileManagerImp ;

    @Spy
    private OrikaBeanMapper orikaBeanMapper;


    /*@Test
    public void testFindAll(){
        System.out.println(ListDTO);
        System.out.println(value);
        assertEquals(ListDTO, value);
        System.out.println(ListDTO);
        System.out.println(value);
    }
    //on a bien une List en retour de la méthode findAll()

    @Test
    public void testFindRank(){assertEquals(ListDTO, personProfileManager.findRank());}

    @Test
    public void testSave(){assertEquals(profileDTO , personProfileManager.save(dto));}
*/
    @Test
    public void testfindAll_TheMethodMustToBeSuccessfullyInvoked() {
        //Initiating
        PersonProfile personProfile = new PersonProfile("Deschamp", "Didier", 40, "20 avenue de la Republique", 75000, "didier@gmail.com", 0760543103, "", 7, false, 0, true, false, "", 10000, "Medical_Confort");
        List<PersonProfile> personProfileList = new ArrayList<>();
        personProfileList.add(personProfile);

        Mockito.doReturn(personProfileList).when(personProfileDAO).findAll();

        //Transition
        List<PersonProfileDTO> personProfileListDTO =  personProfileManagerImp.findAll(); //subscriptionManagerImp.findAllSubscription();

        //Verify the size of the list
        Assert.assertEquals(1, personProfileListDTO.size());

        //Verify that the list is not null
        assertNotNull(personProfileListDTO);

        System.out.println(personProfileListDTO.get(0).getNom());

    }



    

}

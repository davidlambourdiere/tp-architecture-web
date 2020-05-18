package com.lifetech.application.manager;
import com.lifetech.application.dto.PersonProfileDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonProfileDAO;
import com.lifetech.application.manager.PersonProfileManagerImpl;
import com.lifetech.domain.model.PersonProfile;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


public class PersonProfileManagerTest {
    PersonProfileDTO profileDTO;

    PersonProfileManager personProfileManager = new PersonProfileManager() {
        @Override
        public java.util.List<com.lifetech.application.dto.PersonProfileDTO> findAll() {
            return null;
        }

        @Override
        public java.util.List<com.lifetech.application.dto.PersonProfileDTO> findRank() {
            return null;
        }

        @Override
        public com.lifetech.application.dto.PersonProfileDTO save(com.lifetech.application.dto.PersonProfileDTO updatedProfile) {
            return null;
        }
    };

    private PersonProfileDAO dao;
    private List<PersonProfileDTO> ListDTO;
    private PersonProfileDTO dto = new PersonProfileDTO();
    private List<PersonProfile> value = dao.findAll();

    @Test
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

    

}

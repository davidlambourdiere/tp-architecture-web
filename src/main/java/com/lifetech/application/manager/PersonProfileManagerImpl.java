package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonProfileDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonProfileDAO;
import com.lifetech.domain.model.PersonProfile;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PersonProfileManagerImpl implements PersonProfileManager{

    public final PersonProfileDAO personProfileDAO;
    public final OrikaBeanMapper orikaBeanMapper;
    public List<PersonProfileDTO> PersonList;


    public PersonProfileManagerImpl(PersonProfileDAO personProfileDAO, OrikaBeanMapper orikaBeanMapper) {
        this.personProfileDAO = personProfileDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    public List<PersonProfileDTO> findAll() {

        return orikaBeanMapper.mapAsList(personProfileDAO.findAll(), PersonProfileDTO.class);

    }

    public List<PersonProfileDTO> findRank(){
       PersonList = orikaBeanMapper.mapAsList(personProfileDAO.findAll(), PersonProfileDTO.class);
       int Profile_number = 10;
       for (PersonProfileDTO prof: PersonList){
           String profile = prof.getProfile();
           switch(profile) {
               case "Essential_Secure" :
                   prof.setPriority_coef(9);
                   break;

               case "Confort":
                   prof.setPriority_coef(10);
                   break;

               case "Medical_Secure":
                   prof.setPriority_coef(7);
                   break;

               case "Medical_Confort":
                   prof.setPriority_coef(8);
                   break;

               case "Mobile_Urgent" :
                   prof.setPriority_coef(2);
                   break;

               case "Handicap_Urgent" :
                   prof.setPriority_coef(1);
                   break;

               case "Handicap_Essentiel" :
                   prof.setPriority_coef(5);
                   break;

               case "Handicap_Confort" :
                   prof.setPriority_coef(6);
                   break;

               case "Handicap_Medical_Secure" :
                   prof.setPriority_coef(3);
                   break;

               case "Handicap_Medical_Confort" :
                   prof.setPriority_coef(4);
                   break;

               default :
                  System.out.println("le profil n'est pas reconnu !");

           }

       }

         Collections.sort(PersonList, Comparator.comparingInt(PersonProfileDTO :: getPriority_coef));

         return PersonList;
    }


    public  PersonProfileDTO save(PersonProfileDTO updatedpersonProfile) {
        PersonProfile p = personProfileDAO.save(orikaBeanMapper.map(updatedpersonProfile, PersonProfile.class));
        return orikaBeanMapper.map(p, PersonProfileDTO.class);
    }
}

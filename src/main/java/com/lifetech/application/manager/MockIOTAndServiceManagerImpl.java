package com.lifetech.application.manager;

import com.lifetech.application.dto.ExtraCostDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ExtraCostDAO;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.model.ExtraCost;
import com.lifetech.domain.model.Person;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class MockIOTAndServiceManagerImpl implements MockIOTAndServiceManager {
    private final OrikaBeanMapper orikaBeanMapper ;
    private final PersonDAO personDAO;
    private final ExtraCostDAO extraCostDAO;

    public MockIOTAndServiceManagerImpl(OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO, ExtraCostDAO extraCostDAO) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
        this.extraCostDAO = extraCostDAO;

    }

    public List<ExtraCostDTO> simulationExtra(){
        extraCostDAO.deleteAll();

        List<Person> listPerson = personDAO.findAll();
        int i=1;
        long offset = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2020-01-31 00:00:00").getTime();
        long diff = end - offset + 1;
        for (Person person: listPerson ) {
            Random rd = new Random();

          //  Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
           // Timestamp rand2 = new Timestamp(offset + (long)(Math.random() * diff));
            i++;
            if(i%2 == 1){
                Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
                Timestamp rand2 = new Timestamp(offset + (long)(Math.random() * diff));
                ExtraCost extra = new ExtraCost(person, "BAIN GREC",29.99, rand);
                extraCostDAO.save(extra);
                ExtraCost extra2 = new ExtraCost(person,"COFFEE MAKER",99.00,rand2);
                extraCostDAO.save(extra2);

            }else{
                Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
                Timestamp rand2 = new Timestamp(offset + (long)(Math.random() * diff));
                ExtraCost extra = new ExtraCost(person, "CAFE MOULU",2.99, rand);
                extraCostDAO.save(extra);
                ExtraCost extra2 = new ExtraCost(person,"OVEN",600.00,rand2);
                extraCostDAO.save(extra2);
            }
            if(i%3 == 2){
                Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
                Timestamp rand2 = new Timestamp(offset + (long)(Math.random() * diff));
                ExtraCost extra = new ExtraCost(person, "GAMING",50.00, rand);
                extraCostDAO.save(extra);
                ExtraCost extra2 = new ExtraCost(person,"BATHTUB",700.00,rand2);
                extraCostDAO.save(extra2);
            }else{
                Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
                Timestamp rand2 = new Timestamp(offset + (long)(Math.random() * diff));
                ExtraCost extra = new ExtraCost(person, "PISCINE",4.00, rand);
                extraCostDAO.save(extra);
                ExtraCost extra2 = new ExtraCost(person,"BED",300.00,rand2);
                extraCostDAO.save(extra2);
            }
            Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
            Timestamp rand2 = new Timestamp(offset + (long)(Math.random() * diff));
            ExtraCost extra = new ExtraCost(person, "BOUTEILLE DE EAU",4.00, rand);
            extraCostDAO.save(extra);
            ExtraCost extra2 = new ExtraCost(person,"TOILET",99.00,rand2);
            extraCostDAO.save(extra2);
        }

        List<ExtraCostDTO> extraCostList = orikaBeanMapper.mapAsList(extraCostDAO.findAll(), ExtraCostDTO.class);
        return extraCostList ;

    }


}

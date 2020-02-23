package com.lifetech.application.manager;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.application.dto.SubscriptionResidentDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.dao.SubscriptionDAO;
import com.lifetech.domain.dao.SubscriptionResidentDAO;

import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Subscription;
import com.lifetech.domain.model.SubscriptionResident;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SubscriptionResidentManagerImpl implements SubscriptionResidentManager{
    private final SubscriptionResidentDAO subscriptionResidentDAO;
    private final PersonDAO personDAO;
    private final OrikaBeanMapper orikaBeanMapper;
    private final SubscriptionDAO subscriptionDAO;
    Logger logger = Logger.getLogger("com.lifetech.application.manager.SubscriptionResidentManagerImpl");


    public SubscriptionResidentManagerImpl(SubscriptionResidentDAO subscriptionResidentDAO, PersonDAO personDAO, OrikaBeanMapper orikaBeanMapper, SubscriptionDAO subscriptionDAO) {
        this.subscriptionResidentDAO = subscriptionResidentDAO;
        this.personDAO = personDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public SubscriptionResidentDTO save(SubscriptionDTO createSubscriptionDTO) {
        SubscriptionResident createSubscriptionTranslate = new SubscriptionResident();
        Optional<Person> person = personDAO.findByLogin(createSubscriptionDTO.getDescription());
        Subscription subscription = subscriptionDAO.findByName(createSubscriptionDTO.getName());
        createSubscriptionTranslate.setDescription(subscription.getDescription());
        createSubscriptionTranslate.setListofiot(createSubscriptionDTO.getListofiot());
        createSubscriptionTranslate.setListofservice(createSubscriptionDTO.getListofservice());
        createSubscriptionTranslate.setName(createSubscriptionDTO.getName());
        createSubscriptionTranslate.setPrice(createSubscriptionDTO.getPrice());
        createSubscriptionTranslate.setPerson(person.get());
        logger.info("createSubscriptionDTO.getDescription()="+createSubscriptionDTO.getDescription());
        logger.info("subscription.getDescription()="+subscription.getDescription());
        logger.info("person.get().getId()="+person.get().getId());
        logger.info("person="+person.get());





        //SubscriptionResident createSubscription = this.orikaBeanMapper.map(createSubscriptionTranslate,SubscriptionResident.class);
        SubscriptionResident _createSubscription = subscriptionResidentDAO.save(createSubscriptionTranslate);
        SubscriptionResidentDTO resultDTO = this.orikaBeanMapper.map(_createSubscription, SubscriptionResidentDTO.class);
        return resultDTO;
    }
}

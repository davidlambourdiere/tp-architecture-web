package com.lifetech.application.manager;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.SubscriptionDAO;
import com.lifetech.domain.model.Subscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionManagerImp implements SubscriptionManager{
    private final SubscriptionDAO subscriptionDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public SubscriptionManagerImp(SubscriptionDAO subscriptionDAO, OrikaBeanMapper orikaBeanMapper) {
        this.subscriptionDAO = subscriptionDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    public List<SubscriptionDTO> findAll() {
        return orikaBeanMapper.mapAsList(subscriptionDAO.findAll(), SubscriptionDTO.class);

    }
    @Override
    public SubscriptionDTO findById(Long subscriptionId) {
        Subscription s = subscriptionDAO.findById(subscriptionId).orElse(null);
        if(s!=null){
            SubscriptionDTO DTO = orikaBeanMapper.map(s, SubscriptionDTO.class);
            return DTO;
        }
        return null;
    }


    @Override
    public  SubscriptionDTO save(SubscriptionDTO updatedPerson) {
        Subscription s = subscriptionDAO.save(orikaBeanMapper.map(updatedPerson, Subscription.class));
        return orikaBeanMapper.map(s, SubscriptionDTO.class);
    }

    @Override
    public boolean delete(SubscriptionDTO s) {
        try{subscriptionDAO.delete(orikaBeanMapper.map(s, Subscription.class)); return true;}
        catch (Exception ex){return false;}

    }





}

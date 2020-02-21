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

    public List<SubscriptionDTO> findAllSubscription() {
        return orikaBeanMapper.mapAsList(subscriptionDAO.findAll(), SubscriptionDTO.class);

    }
    @Override
    public SubscriptionDTO findSubscriptionById(Long subscriptionId) {
        Subscription s = subscriptionDAO.findById(subscriptionId).orElse(null);
        if(s!=null){
            SubscriptionDTO DTO = orikaBeanMapper.map(s, SubscriptionDTO.class);
            return DTO;
        }
        return null;
    }


    @Override
    public  SubscriptionDTO save(SubscriptionDTO createSubscription) {
        Subscription s = subscriptionDAO.save(orikaBeanMapper.map(createSubscription, Subscription.class));
        return orikaBeanMapper.map(s, SubscriptionDTO.class);
    }

    @Override
    public boolean delete(SubscriptionDTO s) {
        try{subscriptionDAO.delete(orikaBeanMapper.map(s, Subscription.class)); return true;}
        catch (Exception ex){return false;}

    }



   public SubscriptionDTO findSubscriptionByProfile(String name) {
        SubscriptionDTO subToReturn = new SubscriptionDTO();
        switch(name){
            case "essential":
                Subscription essential = subscriptionDAO.findByName(name);
                essential.setPrice(subscriptionDAO.sumProfileEssentialSecure());
                return orikaBeanMapper.map(essential, SubscriptionDTO.class);

            case "serenity":
                Subscription serenity = subscriptionDAO.findByName(name);
                serenity.setPrice(subscriptionDAO.sumProfileSerenity());
                if(serenity!=null) {
                    SubscriptionDTO serenityDTO = orikaBeanMapper.map(serenity, SubscriptionDTO.class);
                    return serenityDTO;
                }
                break;

            case "confort":
                Subscription confort = subscriptionDAO.findByName(name);
                confort.setPrice(subscriptionDAO.sumProfileConfort());
                if(confort!=null) {
                    SubscriptionDTO confortDTO = orikaBeanMapper.map(confort, SubscriptionDTO.class);
                    return confortDTO;
                }
                break;

            case "total confort":
                Subscription totalconfort = subscriptionDAO.findByName(name);
                totalconfort.setPrice(subscriptionDAO.sumProfileTotalConfort());
                if(totalconfort!=null) {
                    SubscriptionDTO totalconfortDTO = orikaBeanMapper.map(totalconfort, SubscriptionDTO.class);
                    return totalconfortDTO;
                }
                break;

            default :
                return null;
        }

       return subToReturn;
   }



    }





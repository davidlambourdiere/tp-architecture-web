package com.lifetech.application.manager;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ReferencesPricesDAO;
import com.lifetech.domain.dao.SubscriptionDAO;
import com.lifetech.domain.model.ReferencesPrices;
import com.lifetech.domain.model.Subscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionManagerImp implements SubscriptionManager{
    private final SubscriptionDAO subscriptionDAO;

    private final ReferencesPricesDAO referencesPricesDAO ;

    private final OrikaBeanMapper orikaBeanMapper;

    public SubscriptionManagerImp(SubscriptionDAO subscriptionDAO, ReferencesPricesDAO referencesPricesDAO, OrikaBeanMapper orikaBeanMapper) {
        this.subscriptionDAO = subscriptionDAO;
        this.referencesPricesDAO = referencesPricesDAO;
        this.orikaBeanMapper = orikaBeanMapper;
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


   public SubscriptionDTO findSubscriptionByProfile(String name) {
        SubscriptionDTO subToReturn;
        switch(name){
            case "essential":
                Subscription essential = subscriptionDAO.findByName(name);
                essential.setPrice(subscriptionDAO.sumProfileEssentialSecure());
                subToReturn =  orikaBeanMapper.map(essential, SubscriptionDTO.class);
                break ;
            case "serenity":
                Subscription serenity = subscriptionDAO.findByName(name);
                serenity.setPrice(subscriptionDAO.sumProfileSerenity());
                subToReturn =   orikaBeanMapper.map(serenity, SubscriptionDTO.class);
                break;

            case "confort":
                Subscription confort = subscriptionDAO.findByName(name);
                confort.setPrice(subscriptionDAO.sumProfileConfort());
                subToReturn = orikaBeanMapper.map(confort, SubscriptionDTO.class);
                break;

            case "total-confort":
                Subscription totalConfort = subscriptionDAO.findByName(name);
                totalConfort.setPrice(subscriptionDAO.sumProfileTotalConfort());
                subToReturn =  orikaBeanMapper.map(totalConfort, SubscriptionDTO.class);
                break;

            default :
                return null;
        }

       return subToReturn;
   }

    //Dont work for the moment
  /* public SubscriptionDTO sumPrice(String subscriptionName, List<String> typeList, List<String> serviceList){
            Subscription subscription = subscriptionDAO.findByName(subscriptionName);
            SubscriptionDTO sub = orikaBeanMapper.map(subscription, SubscriptionDTO.class);
            double price = 0.0 ;

           // List of IOT
            String[] typeOfIOT= sub.getListofiot().split(",");
            System.out.println(typeOfIOT);


            for(String iot : typeOfIOT){
                ReferencesPrices referencesPrices = referencesPricesDAO.findByType(iot);
                price = price + referencesPrices.getPrice();

            }

        // List of Services
           String[] nameOfServices= sub.getListofservice().split(",");
           System.out.println(nameOfServices);

           for(String services : nameOfServices){
               ReferencesPrices referencesPrices = referencesPricesDAO.findByNameService(services);
               price = price + referencesPrices.getPrice();

           }

        if (typeList != null){
            for(String iot : typeList){
                ReferencesPrices referencesPrices = referencesPricesDAO.findByType(iot);
                price += referencesPrices.getPrice();

            }
        }

            if(serviceList !=null){
                for(String services : serviceList){
                    ReferencesPrices referencesPrices = referencesPricesDAO.findByNameService(services);
                    price += referencesPrices.getPrice();

                }
            }
            sub.setPrice(price);
        return sub;
   }*/
}





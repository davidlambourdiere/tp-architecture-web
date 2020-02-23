package com.lifetech.domain.dao;


import com.lifetech.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDAO extends JpaRepository<Subscription, Long> {

    Subscription findByName(String subscriptionName);

    @Query(value = "SELECT SUM(strap.price + heater.price+references_prices.price) FROM Strap,Heater,References_prices where references_prices.name_service ='sport'", nativeQuery = true)
    public Double sumProfileEssentialSecure();

    @Query(value = "SELECT SUM(heater.price + strap.price + references_prices.price )  FROM Heater,Strap,References_prices where references_prices.num_serie='S01'",nativeQuery=true )
    public  Double sumProfileSerenity();

    @Query(value = "SELECT SUM(light.price + heater.price + strap.price+ shutter.price + references_prices.price) FROM Light,Heater,Strap,Shutter,References_prices where references_prices.num_serie='A01' ",nativeQuery = true)
    public Double sumProfileConfort();

    @Query(value = "SELECT SUM(light.price + shutter.price + heater.price + strap.price + clock.price + references_prices.price)  FROM Light,Shutter,Heater,Strap,Clock,References_prices where references_prices.name_service='bingo' ",nativeQuery = true)
    public Double sumProfileTotalConfort();

}


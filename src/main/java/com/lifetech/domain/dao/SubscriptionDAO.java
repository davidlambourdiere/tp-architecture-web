package com.lifetech.domain.dao;


import com.lifetech.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDAO extends JpaRepository<Subscription, Long> {

    Subscription findByName(String subscriptionName);

    @Query(value = "SELECT SUM(lifetech.strap.price + lifetech.heater.price+referencesprices.price) FROM lifetech.strap,lifetech.heater,lifetech.referencesprices where lifetech.referencesprices.nameService ='sport'", nativeQuery = true)
    public Double sumProfileEssentialSecure();

    @Query(value = "SELECT SUM(heater.price + strap.price + referencesprices.price )  FROM Heater,Strap,lifetech.referencesprices where referencesprices.numSerie='S01'",nativeQuery=true )
    public  Double sumProfileSerenity();

    @Query(value = "SELECT SUM(light.price + heater.price + strap.price+ shutter.price + referencesprices.price) FROM Light,Heater,Strap,Shutter,Referencesprices where referencesprices.numSerie='A01' ",nativeQuery = true)
    public Double sumProfileConfort();

    @Query(value = "SELECT SUM(light.price + shutter.price + heater.price + strap.price + clock.price + referencesprices.price)  FROM Light,Shutter,Heater,Strap,Clock,Referencesprices where referencesprices.nameService='bingo' ",nativeQuery = true)
    public Double sumProfileTotalConfort();

}


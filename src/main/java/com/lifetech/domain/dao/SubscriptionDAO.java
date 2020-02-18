package com.lifetech.domain.dao;


import com.lifetech.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDAO extends JpaRepository<Subscription, Long> {

    Subscription findByName(String subscriptionName);

    @Query(value = "SELECT SUM(strap.price + heater.price)  FROM Strap,Heater", nativeQuery = true)
    public Double sumProfileEssentialSecure();

    @Query(value = "SELECT SUM(ligh.price + heater.price + strap.price)  FROM Light,Heater,Strap",nativeQuery=true )
    public  Double sumProfileSerenity();

    @Query(value = "SELECT SUM(light.price + heater.price + strap.price) AS price FROM Light,Heater,Strap ",nativeQuery = true)
    public Double sumProfileConfort();

    @Query(value = "SELECT SUM(light.price + shutter.price + heater.price + strap.price)  FROM Light,Shutter,Heater,Strap ",nativeQuery = true)
    public Double sumProfileTotalConfort();

  @Query(value =" SELECT subscription.*, SUM(strap.price+heater.price) AS price FROM subscription,strap,heater",nativeQuery = true)
  Subscription findEssentialSubscription();
}


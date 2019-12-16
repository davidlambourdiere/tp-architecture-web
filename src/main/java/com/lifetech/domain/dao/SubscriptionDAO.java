package com.lifetech.domain.dao;


import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionDAO extends JpaRepository<Subscription, Long> {

    List<Subscription> findByName(Subscription subscriptionName);

}

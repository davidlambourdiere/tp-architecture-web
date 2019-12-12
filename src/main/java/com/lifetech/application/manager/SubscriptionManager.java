package com.lifetech.application.manager;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.domain.model.Subscription;

import java.util.List;

public interface SubscriptionManager {
    List<SubscriptionDTO> findAll();

    SubscriptionDTO findById(Long subscriptionId);

    SubscriptionDTO save(SubscriptionDTO updatedSubscription);

    boolean delete(SubscriptionDTO deletedSubscription);
}

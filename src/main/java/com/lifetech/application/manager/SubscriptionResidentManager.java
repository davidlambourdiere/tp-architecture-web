package com.lifetech.application.manager;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.application.dto.SubscriptionResidentDTO;

public interface SubscriptionResidentManager {

    SubscriptionResidentDTO save(SubscriptionDTO createSubscription);
}

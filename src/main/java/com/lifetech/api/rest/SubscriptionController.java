package com.lifetech.api.rest;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.application.dto.SubscriptionResidentDTO;
import com.lifetech.application.manager.SubscriptionManager;
import com.lifetech.application.manager.SubscriptionResidentManager;
import com.lifetech.domain.model.Subscription;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubscriptionController extends RestBaseController {

    private final SubscriptionManager subscriptionManager;
    private final SubscriptionResidentManager subscriptionResidentManager;

    public SubscriptionController(SubscriptionManager subscriptionManager, SubscriptionResidentManager subscriptionResidentManager) {
        this.subscriptionManager = subscriptionManager;
        this.subscriptionResidentManager = subscriptionResidentManager;
    }

    @GetMapping("subscription/findAll")
    private List<SubscriptionDTO> findAllPerson(){
        return subscriptionManager.findAllSubscription();
    }

    @GetMapping("subscription/findById/{id}")
    private Subscription getSubscriptionById(@PathVariable(value = "id") String subscriptionId) {
      //  Subscription sub = subscriptionManager.findSubscriptionById(subscriptionId);


        return subscriptionManager.findSubscriptionById(subscriptionId);
    }

    
    @GetMapping("subscription/findSubscriptionByProfile/{name}")
    private SubscriptionDTO findSubscriptionByProfile(@PathVariable(value = "name") String name) {
        return subscriptionManager.findSubscriptionByProfile(name);


    }
    @PostMapping("subscription/insertSubscriptionForResident")
    private SubscriptionResidentDTO insertNewResidentInSubscription(@Valid @RequestBody SubscriptionDTO newSubscription) {
        return subscriptionResidentManager.save(newSubscription);


    }
}

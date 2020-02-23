package com.lifetech.api.rest;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.application.dto.SubscriptionResidentDTO;
import com.lifetech.application.manager.SubscriptionManager;
import com.lifetech.application.manager.SubscriptionResidentManager;
import org.springframework.http.ResponseEntity;
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



    @GetMapping("subscription/findById/{id}")
    private ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable(value = "id") Long subscriptionId) {
        SubscriptionDTO sub = subscriptionManager.findSubscriptionById(subscriptionId);


        return ResponseEntity.ok().body(sub);
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

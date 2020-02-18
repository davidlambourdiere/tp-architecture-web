package com.lifetech.api.rest;

import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.application.manager.SubscriptionManager;
import com.lifetech.infrastructure.exception.LifetechException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubscriptionController extends RestBaseController {

    private final SubscriptionManager subscriptionManager;

    public SubscriptionController(SubscriptionManager subscriptionManager) {
        this.subscriptionManager = subscriptionManager;
    }

    @GetMapping("subscription")
    private List<SubscriptionDTO> findAllSubscription() {
        return subscriptionManager.findAllSubscription();
    }

    @GetMapping("subscription/findById/{id}")
    private ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable(value = "id") Long subscriptionId) {
        SubscriptionDTO sub = subscriptionManager.findSubscriptionById(subscriptionId);


        return ResponseEntity.ok().body(sub);
    }

    @PostMapping("subscription/createSubscription")
    private SubscriptionDTO createSubscription(@Valid @RequestBody SubscriptionDTO s) {
        return subscriptionManager.save(s);
    }

    @DeleteMapping("subscription/deleteSubscription/{id}")
    private boolean deleteSubscription(@PathVariable(value = "id") Long subscriptionId) {
        SubscriptionDTO s = subscriptionManager.findSubscriptionById(subscriptionId);

        boolean response = false;
        try {
            subscriptionManager.delete(s);
            response = true;
        } catch (Exception ex) {
        }

        return response;
    }

    @GetMapping("subscription/findSubscriptionByProfile/{name}")
    private SubscriptionDTO findSubscriptionByProfile(@PathVariable(value = "name") String name) {
        return subscriptionManager.findSubscriptionByProfile(name);


    }


    @GetMapping("subscription/findByName/{name}")
    private ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable(value = "name") String subscriptionName) {
        SubscriptionDTO subbyname = subscriptionManager.findSubscriptionByName(subscriptionName);


        return ResponseEntity.ok().body(subbyname);
    }

}

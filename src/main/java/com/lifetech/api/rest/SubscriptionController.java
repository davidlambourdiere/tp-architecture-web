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
    private List<SubscriptionDTO> findAllSubscription(){
        return subscriptionManager.findAllSubscription();
    }

    @GetMapping("subscription/findById/{id}")
    private ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable(value = "id") Long subscriptionId) {
        SubscriptionDTO sub = subscriptionManager.findSubscriptionById(subscriptionId);


        return ResponseEntity.ok().body(sub);
    }



    @PutMapping("subscription/updateSubscription/{id}")
    private ResponseEntity<SubscriptionDTO> updateSubscription(@PathVariable(value = "id") Long subscriptionId,
                                                               @Valid @RequestBody SubscriptionDTO subDetails)  {
        SubscriptionDTO s = subscriptionManager.findSubscriptionById(subscriptionId);


        s.setName(subDetails.getName());
        s.setListofiot(subDetails.getListofiot());
        s.setListofservice(subDetails.getListofservice());
        s.setPrice(subDetails.getPrice());
        final SubscriptionDTO updatedSubscription = subscriptionManager.save(s);
        return ResponseEntity.ok(updatedSubscription);
    }


    @PostMapping("subscription/createSubscription")
    private SubscriptionDTO createSubscription(@Valid @RequestBody SubscriptionDTO s) {
        return subscriptionManager.save(s);
    }

    @DeleteMapping("subscription/deleteSubscription/{id}")
    private boolean deleteSubscription(@PathVariable(value = "id") Long subscriptionId)  {
        SubscriptionDTO s = subscriptionManager.findSubscriptionById(subscriptionId) ;

        boolean response = false;
        try {
            subscriptionManager.delete(s);
            response = true;
        }catch (Exception ex){}

        return response;
    }



}

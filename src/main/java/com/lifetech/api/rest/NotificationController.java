package com.lifetech.api.rest;

import com.lifetech.application.dto.NotificationContainerInitializeDTO;
import com.lifetech.application.dto.NotificationDTO;
import com.lifetech.application.dto.PersonDTO;
import com.lifetech.application.manager.NotificationManager;
import com.lifetech.domain.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController extends RestBaseController{

    private final NotificationManager notificationManager;


    public NotificationController(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }
    @GetMapping("/notification/findUser/{username}")
    private PersonDTO findUser(@PathVariable("username") String username){
        return notificationManager.findUser(username);
    }

    @GetMapping("/notification/sent/{username}")
    private List<NotificationDTO> sentNotification(@PathVariable("username") String username){
        return notificationManager.sentNotification(username);
    }

    @GetMapping("/notification/received/{username}")
    private List<NotificationDTO> receivedNotification(@PathVariable("username") String username){
        return notificationManager.receivedNotification(username);
    }

    @GetMapping("/notification/initialized/{username}")
    private NotificationContainerInitializeDTO initializedNotification(@PathVariable("username") String username){
        return notificationManager.initializedNotification(username);
    }

}

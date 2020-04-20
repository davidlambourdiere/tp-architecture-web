package com.lifetech.application.manager;

import com.lifetech.application.dto.NotificationContainerInitializeDTO;
import com.lifetech.application.dto.NotificationDTO;
import com.lifetech.application.dto.PersonDTO;

import java.util.List;

public interface NotificationManager {
    PersonDTO findUser(String username);

    List<NotificationDTO> receivedNotification(String username);

    List<NotificationDTO> sentNotification(String username);

    NotificationContainerInitializeDTO initializedNotification(String username);

    NotificationDTO sendMessage(NotificationDTO message);
}

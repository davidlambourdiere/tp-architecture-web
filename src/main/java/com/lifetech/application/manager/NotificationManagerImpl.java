package com.lifetech.application.manager;

import com.lifetech.application.dto.NotificationContainerInitializeDTO;
import com.lifetech.application.dto.NotificationDTO;
import com.lifetech.application.dto.PersonDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.NotificationDAO;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.model.Notification;
import com.lifetech.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationManagerImpl implements  NotificationManager{

    private static final Logger LOG = LoggerFactory.getLogger(NotificationManagerImpl.class);

    private final NotificationDAO notificationDAO;


    private final PersonDAO personDAO;


    private final OrikaBeanMapper orikaBeanMapper;

    public NotificationManagerImpl(PersonDAO personDAO, OrikaBeanMapper orikaBeanMapper, NotificationDAO notificationDAO) {
        this.personDAO = personDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.notificationDAO = notificationDAO;
    }


    public PersonDTO findUser(String username) {
        Person person = personDAO.findByLogin(username);
        PersonDTO personDTO = orikaBeanMapper.map(person, PersonDTO.class);
        return personDTO;
    }

    @Override
    public List<NotificationDTO> receivedNotification(String username) {
        List<Notification> notificationsReceived = notificationDAO.findAllByDestinataire(username);
        List<NotificationDTO> notificationDTOS = orikaBeanMapper.mapAsList(notificationsReceived, NotificationDTO.class);
        return notificationDTOS;
    }

    @Override
    public List<NotificationDTO> sentNotification(String username) {
        List<Notification> notificationsSent = notificationDAO.findAllByEmetteur(username);
        List<NotificationDTO> notificationDTOS = orikaBeanMapper.mapAsList(notificationsSent, NotificationDTO.class);
        return notificationDTOS;
    }

    @Override
    public NotificationContainerInitializeDTO initializedNotification(String username) {
        NotificationContainerInitializeDTO notificationContainerInitializeDTO = new NotificationContainerInitializeDTO();
        String countMessagesReceived = Long.toString(notificationDAO.countAllByDestinataire(username));
        String countMessagesSent = Long.toString(notificationDAO.countAllByEmetteur(username));
        String countMessagesReceivedNotRead = Long.toString(notificationDAO.countAllByDestinataireAndIsread(username, false));
        notificationContainerInitializeDTO.setCountMessagesReceived(countMessagesReceived);
        notificationContainerInitializeDTO.setCountMessagesSent(countMessagesSent);
        notificationContainerInitializeDTO.setCountMessagesReceivedNotRead(countMessagesReceivedNotRead);
        return notificationContainerInitializeDTO;
    }

    @Override
    public NotificationDTO sendMessage(NotificationDTO message) {
        Notification notification = orikaBeanMapper.map(message, Notification.class);
        notificationDAO.save(notification);
        return message;
    }
}

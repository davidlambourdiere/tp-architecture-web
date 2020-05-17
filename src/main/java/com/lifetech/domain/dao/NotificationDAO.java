package com.lifetech.domain.dao;

import com.lifetech.domain.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDAO extends JpaRepository<Notification, Long> {

    List<Notification> findAllByDestinataire(String username);

    List<Notification> findAllByEmetteur(String username);

    Long countAllByDestinataire(String username);

    Long countAllByEmetteur(String username);

    Long countAllByDestinataireAndIsread(String username, boolean isread);
}

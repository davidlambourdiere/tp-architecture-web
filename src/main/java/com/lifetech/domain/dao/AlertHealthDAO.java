package com.lifetech.domain.dao;
import com.lifetech.domain.model.AlertHealth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertHealthDAO extends JpaRepository<AlertHealth, Long> {
    List<AlertHealth> findByStatus(String status);

    int countByStatus(String status);
}

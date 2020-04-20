package com.lifetech.domain.dao;
import com.lifetech.domain.model.AlertHealth;
import com.lifetech.domain.model.Strap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertHealthDAO extends JpaRepository<AlertHealth, Long> {
    List<AlertHealth> findByStatus(String status);

    int countByStatus(String status);

    int countByStrap(Long strap);
    int countByStrapAndStatus(Long strap, String status);
}

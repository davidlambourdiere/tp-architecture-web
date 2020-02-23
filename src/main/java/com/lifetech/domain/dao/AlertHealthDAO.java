package com.lifetech.domain.dao;
import com.lifetech.domain.model.AlertHealth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertHealthDAO extends JpaRepository<AlertHealth, Long> {
}

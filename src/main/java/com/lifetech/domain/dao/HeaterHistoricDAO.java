package com.lifetech.domain.dao;

import com.lifetech.domain.model.HeaterHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaterHistoricDAO extends JpaRepository<HeaterHistoric, Long> {
}

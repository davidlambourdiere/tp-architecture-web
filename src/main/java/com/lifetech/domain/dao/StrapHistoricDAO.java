package com.lifetech.domain.dao;

import com.lifetech.domain.model.StrapHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrapHistoricDAO extends JpaRepository<StrapHistoric, Long> {
}

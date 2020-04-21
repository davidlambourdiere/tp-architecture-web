package com.lifetech.domain.dao;

import com.lifetech.domain.model.LightHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightHistoricDAO extends JpaRepository<LightHistoric, Long> {
    List<LightHistoric> findAllByLightId(Long id);
}

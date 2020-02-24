package com.lifetech.domain.dao;

import com.lifetech.domain.model.ShutterHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ShutterHistoricDAO extends JpaRepository<ShutterHistoric, Long> {
    List<ShutterHistoric> findAllByShutterid(Long id);


}

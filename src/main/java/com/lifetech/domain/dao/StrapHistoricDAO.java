package com.lifetech.domain.dao;

import com.lifetech.domain.model.StrapHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrapHistoricDAO extends JpaRepository<StrapHistoric, Long> {
    List<StrapHistoric> findAllByStrapId(Long id);

}

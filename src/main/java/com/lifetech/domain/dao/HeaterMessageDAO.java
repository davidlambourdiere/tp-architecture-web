package com.lifetech.domain.dao;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaterMessageDAO extends JpaRepository<HeaterMessage, Long> {
    List<HeaterMessage> findHeaterMessageByHeater (Heater id);

    HeaterMessage findFirstByOrderByInsertDateIdDesc();




}

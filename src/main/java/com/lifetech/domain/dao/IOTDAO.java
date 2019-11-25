package com.lifetech.domain.dao;

import com.lifetech.domain.model.IOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOTDAO  extends JpaRepository<IOT, Long> {
}

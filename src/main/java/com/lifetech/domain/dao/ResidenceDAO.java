package com.lifetech.domain.dao;

import com.lifetech.domain.model.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceDAO extends JpaRepository<Residence,Long> {
}

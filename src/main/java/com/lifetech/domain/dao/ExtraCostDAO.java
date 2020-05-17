package com.lifetech.domain.dao;

import com.lifetech.domain.model.ExtraCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraCostDAO extends JpaRepository <ExtraCost,Long> {
    
}

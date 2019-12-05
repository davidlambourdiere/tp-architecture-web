package com.lifetech.domain.dao;

import com.lifetech.domain.model.Strap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrapDAO extends JpaRepository<Strap, Long> {
}

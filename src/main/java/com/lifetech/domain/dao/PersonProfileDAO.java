package com.lifetech.domain.dao;

import com.lifetech.domain.model.PersonProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonProfileDAO extends JpaRepository<PersonProfile, Long> {




}

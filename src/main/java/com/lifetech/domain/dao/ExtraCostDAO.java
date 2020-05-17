package com.lifetech.domain.dao;

import com.lifetech.domain.model.ExtraCost;
import com.lifetech.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraCostDAO extends JpaRepository <ExtraCost,Long> {

    List<ExtraCost> findByPerson(Person person);
}

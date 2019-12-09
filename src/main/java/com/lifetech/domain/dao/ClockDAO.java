package com.lifetech.domain.dao;

import com.lifetech.domain.model.Clock;
import com.lifetech.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockDAO extends JpaRepository<Clock, Long> {
    List<Clock> findByPerson(Person person);
}

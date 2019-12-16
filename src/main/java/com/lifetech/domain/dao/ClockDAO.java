package com.lifetech.domain.dao;

import com.lifetech.domain.model.Clock;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockDAO extends JpaRepository<Clock, Long> {
    List<Clock> findByPerson(Person person);

    Long countByPerson(Person person);

}

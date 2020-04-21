package com.lifetech.domain.dao;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Residence;
import com.lifetech.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaterDAO extends JpaRepository<Heater, Long> {
    Long countByPerson(Person person);

    @Query(countQuery="count h.id from Heather h where Residence.id = :residenceId", nativeQuery = true)
    Long countByPersonId(@Param("residenceId") Long residenceId);

    List<Heater> findByRoom(Room room);

    Heater findById(String id);
}

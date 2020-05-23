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
import java.util.Optional;

@Repository
public interface HeaterDAO extends JpaRepository<Heater, Long> {
    Long countByPerson(Person person);

    @Query(value="select count(*) from heater where heater.person_id = ?1 ;", nativeQuery=true)
    String countByPersonId(String personid);

    List<Heater> findByRoom(Room room);

    List<Heater> findAllByPersonId(Long id);

    Heater findByIpadress(String ipadress);

    Heater findById(String id);

    @Query(value="select count(*) from heater join person on person.id = heater.person_id where person.residence_id = ?1 ;", nativeQuery=true)
    String countByResidenceId(String residenceid);
}

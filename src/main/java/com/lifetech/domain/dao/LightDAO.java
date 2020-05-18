package com.lifetech.domain.dao;

import com.lifetech.domain.model.Light;
import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Residence;
import com.lifetech.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightDAO  extends JpaRepository<Light, Long> {

    List<Light> findAllByPersonId(Long id);

    Long countByPerson(Person person);

    List<Light> findByRoom(Room room);

    @Query(value="select count(*) from light where light.person_id = ?1 ;", nativeQuery=true)
    String countByPersonId(String personid);

    @Query(value="select count(*) from light join person on person.id = light.person_id where person.residence_id = ?1 ;", nativeQuery=true)
    String countByResidenceId(String residenceid);
}

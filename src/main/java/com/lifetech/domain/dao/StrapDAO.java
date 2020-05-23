package com.lifetech.domain.dao;

import com.lifetech.domain.model.Strap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StrapDAO extends JpaRepository<Strap, Long> {
    //@Query(value = "", nativeQuery = true)
    @Query(value="select count(*) from strap where strap.person_id = ?1 ;", nativeQuery=true)
    String countByPersonId(String personid);

    @Query(value="select count(*) from strap join person on person.id = strap.person_id where person.residence_id = ?1 ;", nativeQuery=true)
    String countByResidenceId(String residenceid);
}

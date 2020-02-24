package com.lifetech.domain.dao;

import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.PersonStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    List<Person> findAllByResidenceId(long residenceId);

    Person findByLogin(String personLogin);

    int countByUserrole(PersonStatus userrole);

    List<Person> findByUserrole(PersonStatus personStatus);
}

package com.demospringboot.domain.dao;

import com.demospringboot.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    List<Person> findAllByName(String name);
}

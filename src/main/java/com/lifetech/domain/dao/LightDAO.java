package com.lifetech.domain.dao;

import com.lifetech.domain.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightDAO  extends JpaRepository<Light, Long> {

    List<Light> findAllByPersonId(Long id);
}

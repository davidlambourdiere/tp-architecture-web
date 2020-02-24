package com.lifetech.domain.dao;

import com.lifetech.domain.model.ReferencesPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferencesPricesDAO extends JpaRepository<ReferencesPrices, Long> {


    ReferencesPrices findByType(String iot);
    ReferencesPrices findByNameService(String nameService);
}

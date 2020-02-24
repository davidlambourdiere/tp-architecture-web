package com.lifetech.domain.dao;

import com.lifetech.domain.model.SubscriptionResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionResidentDAO extends JpaRepository<SubscriptionResident,Long> {

}

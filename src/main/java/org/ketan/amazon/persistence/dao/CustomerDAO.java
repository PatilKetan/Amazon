package org.ketan.amazon.persistence.dao;

import org.ketan.amazon.persistence.db.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity, Integer> {

}

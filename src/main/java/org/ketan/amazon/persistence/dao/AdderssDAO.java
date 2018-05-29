package org.ketan.amazon.persistence.dao;

import org.ketan.amazon.persistence.db.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdderssDAO extends JpaRepository<AddressEntity, Integer> {

}

package org.ketan.amazon.persistence.dao;

import org.ketan.amazon.persistence.db.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<ProductEntity, Integer> {

}

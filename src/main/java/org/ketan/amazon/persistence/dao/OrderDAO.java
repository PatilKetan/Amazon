package org.ketan.amazon.persistence.dao;

import org.ketan.amazon.persistence.db.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, Integer> {

}

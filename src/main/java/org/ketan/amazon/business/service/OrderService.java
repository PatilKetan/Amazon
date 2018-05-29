package org.ketan.amazon.business.service;

import java.util.List;

import org.ketan.amazon.business.dto.OrderDTO;
import org.ketan.amazon.business.dto.OrderInDTO;

public interface OrderService {

	OrderDTO save(OrderInDTO orderInDTO);

	List<OrderDTO> findAll();

	OrderDTO findOne(Integer id);

	OrderDTO update(Integer id, OrderInDTO orderInDTO);

	void delete(Integer id);

}

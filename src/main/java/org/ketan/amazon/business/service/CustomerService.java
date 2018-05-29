package org.ketan.amazon.business.service;

import java.util.List;

import org.ketan.amazon.business.dto.CustomerDTO;
import org.ketan.amazon.business.dto.CustomerInDTO;
import org.ketan.amazon.persistence.db.CustomerEntity;

public interface CustomerService {

	List<CustomerDTO> findAll();

	CustomerDTO save(CustomerInDTO customerInDTO);

	CustomerDTO findOne(Integer id);

	CustomerDTO update(Integer id, CustomerInDTO customerInDTO);

	void delete(Integer id);

	CustomerDTO createCustomerDTO(CustomerEntity customerEntity);

}

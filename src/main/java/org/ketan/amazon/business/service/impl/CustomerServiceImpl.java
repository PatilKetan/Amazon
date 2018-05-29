package org.ketan.amazon.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ketan.amazon.business.dto.AddressDTO;
import org.ketan.amazon.business.dto.CustomerDTO;
import org.ketan.amazon.business.dto.CustomerInDTO;
import org.ketan.amazon.business.mapper.DozerBeanMapper;
import org.ketan.amazon.business.service.AddressService;
import org.ketan.amazon.business.service.CustomerService;
import org.ketan.amazon.persistence.dao.CustomerDAO;
import org.ketan.amazon.persistence.db.AddressEntity;
import org.ketan.amazon.persistence.db.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AddressService addressService;

	@Autowired
	private DozerBeanMapper beanMapper;

	@Override
	public CustomerDTO save(CustomerInDTO customerInDTO) {
		CustomerEntity customerEntity = beanMapper.map(customerInDTO, CustomerEntity.class);
		customerEntity = customerDAO.save(customerEntity);
		if (!CollectionUtils.isEmpty(customerInDTO.getAddressInDTOs())) {
			List<AddressEntity> addressEntities = addressService.save(customerInDTO.getAddressInDTOs(), customerEntity);
			customerEntity.setAddressEntities(addressEntities);
		}
		return createCustomerDTO(customerEntity);
	}

	@Override
	public CustomerDTO findOne(Integer id) {
		CustomerEntity customerEntity = customerDAO.findOne(id);
		return createCustomerDTO(customerEntity);
	}

	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerEntity> customerEntities = customerDAO.findAll();
		return createCustomerDTOs(customerEntities);
	}

	@Override
	public CustomerDTO update(Integer id, CustomerInDTO customerInDTO) {
		CustomerEntity customerEntity = customerDAO.findOne(id);
		beanMapper.map(customerInDTO, customerEntity);
		return createCustomerDTO(customerDAO.save(customerEntity));
	}

	@Override
	public void delete(Integer id) {
		CustomerEntity customerEntity = customerDAO.findOne(id);
		customerDAO.delete(customerEntity);
	}

	public List<CustomerDTO> createCustomerDTOs(List<CustomerEntity> customerEntities) {
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		for (CustomerEntity customerEntity : customerEntities) {
			customerDTOs.add(createCustomerDTO(customerEntity));
		}
		return customerDTOs;
	}

	@Override
	public CustomerDTO createCustomerDTO(CustomerEntity customerEntity) {
		List<AddressDTO> addressDTOs = addressService.createAddressDTOs(customerEntity.getAddressEntities());
		CustomerDTO customerDTO = beanMapper.map(customerEntity, CustomerDTO.class);
		customerDTO.setAddressDTOs(addressDTOs);
		return customerDTO;
	}

	public CustomerEntity createCustomerEntity(CustomerInDTO customerInDTO) {
		return beanMapper.map(customerInDTO, CustomerEntity.class);
	}

}

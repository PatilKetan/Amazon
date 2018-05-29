package org.ketan.amazon.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ketan.amazon.business.dto.AddressDTO;
import org.ketan.amazon.business.dto.AddressInDTO;
import org.ketan.amazon.business.mapper.DozerBeanMapper;
import org.ketan.amazon.business.service.AddressService;
import org.ketan.amazon.persistence.dao.AdderssDAO;
import org.ketan.amazon.persistence.db.AddressEntity;
import org.ketan.amazon.persistence.db.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AdderssDAO adderssDAO;

	@Autowired
	private DozerBeanMapper beanMapper;

	@Override
	public List<AddressEntity> save(List<AddressInDTO> addressInDTOs, CustomerEntity customerEntity) {
		List<AddressEntity> addressEntities = createAddressEntities(addressInDTOs, customerEntity);
		return adderssDAO.save(addressEntities);
	}

	@Override
	public List<AddressDTO> createAddressDTOs(List<AddressEntity> addressEntities) {
		List<AddressDTO> addressDTOs = new ArrayList<>();
		for (AddressEntity addressEntity : addressEntities) {
			addressDTOs.add(createAddressDTO(addressEntity));
		}
		return addressDTOs;
	}

	public AddressDTO createAddressDTO(AddressEntity addressEntity) {
		return beanMapper.map(addressEntity, AddressDTO.class);
	}

	private List<AddressEntity> createAddressEntities(List<AddressInDTO> addressInDTOs, CustomerEntity customerEntity) {
		List<AddressEntity> addressEntities = new ArrayList<>();
		for (AddressInDTO addressInDTO : addressInDTOs) {
			addressEntities.add(createAddressEntity(addressInDTO, customerEntity));
		}
		return addressEntities;
	}

	public AddressEntity createAddressEntity(AddressInDTO addressInDTO, CustomerEntity customerEntity) {
		AddressEntity addressEntity = beanMapper.map(addressInDTO, AddressEntity.class);
		addressEntity.setCustomerEntity(customerEntity);
		return addressEntity;
	}

}

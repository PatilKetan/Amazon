package org.ketan.amazon.business.service;

import java.util.List;

import org.ketan.amazon.business.dto.AddressDTO;
import org.ketan.amazon.business.dto.AddressInDTO;
import org.ketan.amazon.persistence.db.AddressEntity;
import org.ketan.amazon.persistence.db.CustomerEntity;

public interface AddressService {

	List<AddressEntity> save(List<AddressInDTO> addressInDTOs, CustomerEntity customerEntity);

	List<AddressDTO> createAddressDTOs(List<AddressEntity> addressEntities);

}

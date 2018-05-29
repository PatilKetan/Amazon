package org.ketan.amazon.business.dto;

import java.util.List;

public class CustomerInDTO {

	private String name;
	private List<AddressInDTO> addressInDTOs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AddressInDTO> getAddressInDTOs() {
		return addressInDTOs;
	}

	public void setAddressInDTOs(List<AddressInDTO> addressInDTOs) {
		this.addressInDTOs = addressInDTOs;
	}

}

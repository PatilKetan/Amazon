package org.ketan.amazon.business.dto;

import java.util.List;

public class CustomerDTO {

	private Integer id;
	private String name;
	private List<AddressDTO> addressDTOs;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<AddressDTO> getAddressDTOs() {
		return addressDTOs;
	}
	public void setAddressDTOs(List<AddressDTO> addressDTOs) {
		this.addressDTOs = addressDTOs;
	}


}

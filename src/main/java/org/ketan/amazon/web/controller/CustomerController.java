package org.ketan.amazon.web.controller;

import java.util.List;

import org.ketan.amazon.business.dto.CustomerDTO;
import org.ketan.amazon.business.dto.CustomerInDTO;
import org.ketan.amazon.business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public CustomerDTO save(@RequestBody CustomerInDTO customerInDTO) {
		return customerService.save(customerInDTO);
	}

	@GetMapping
	public List<CustomerDTO> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public CustomerDTO findOne(@PathVariable Integer id) {
		return customerService.findOne(id);
	}

	@PutMapping("/{id}")
	public CustomerDTO update(@PathVariable Integer id, @RequestBody CustomerInDTO customerInDTO) {
		return customerService.update(id, customerInDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		customerService.delete(id);
	}
}

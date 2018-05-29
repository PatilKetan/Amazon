package org.ketan.amazon.web.controller;

import java.util.List;

import org.ketan.amazon.business.dto.OrderDTO;
import org.ketan.amazon.business.dto.OrderInDTO;
import org.ketan.amazon.business.service.OrderService;
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
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public OrderDTO save(@RequestBody OrderInDTO orderInDTO) {
		return orderService.save(orderInDTO);
	}

	@GetMapping
	public List<OrderDTO> findAll() {
		return orderService.findAll();
	}

	@GetMapping("/{id}")
	public OrderDTO findOne(@PathVariable Integer id) {
		return orderService.findOne(id);
	}

	@PutMapping("/{id}")
	public OrderDTO update(@PathVariable Integer id, @RequestBody OrderInDTO orderInDTO) {
		return orderService.update(id, orderInDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		orderService.delete(id);
	}
}

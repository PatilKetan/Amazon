package org.ketan.amazon.web.controller;

import java.util.List;

import org.ketan.amazon.business.dto.ProductDTO;
import org.ketan.amazon.business.dto.ProductInDTO;
import org.ketan.amazon.business.service.ProductService;
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
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ProductDTO save(@RequestBody ProductInDTO productInDTO) {
		return productService.save(productInDTO);
	}

	@GetMapping
	public List<ProductDTO> findAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public ProductDTO findOne(@PathVariable Integer id) {
		return productService.findOne(id);
	}

	@PutMapping("/{id}")
	public ProductDTO update(@PathVariable Integer id, @RequestBody  ProductInDTO productInDTO) {
		return productService.update(id, productInDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		productService.delete(id);
	}

}

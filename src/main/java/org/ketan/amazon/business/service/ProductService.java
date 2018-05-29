package org.ketan.amazon.business.service;

import java.util.List;

import org.ketan.amazon.business.dto.ProductDTO;
import org.ketan.amazon.business.dto.ProductInDTO;
import org.ketan.amazon.persistence.db.ProductEntity;

public interface ProductService {

	ProductDTO save(ProductInDTO productInDTO);

	List<ProductDTO> findAll();

	ProductDTO findOne(Integer id);

	ProductDTO update(Integer id, ProductInDTO productInDTO);

	void delete(Integer id);

	ProductDTO createProductDTO(ProductEntity productEntity);

}

package org.ketan.amazon.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ketan.amazon.business.dto.ProductDTO;
import org.ketan.amazon.business.dto.ProductInDTO;
import org.ketan.amazon.business.mapper.DozerBeanMapper;
import org.ketan.amazon.business.service.ProductService;
import org.ketan.amazon.persistence.dao.ProductDAO;
import org.ketan.amazon.persistence.db.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private DozerBeanMapper beanMapper;

	@Override
	public ProductDTO save(ProductInDTO productInDTO) {
		ProductEntity productEntity = productDAO.save(createProductEntity(productInDTO));
		return createProductDTO(productEntity);
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> productEntities = productDAO.findAll();
		return createProductDTOs(productEntities);
	}

	@Override
	public ProductDTO findOne(Integer id) {
		ProductEntity productEntity = productDAO.findOne(id);
		return createProductDTO(productEntity);
	}

	@Override
	public ProductDTO update(Integer id, ProductInDTO productInDTO) {
		ProductEntity productEntity = productDAO.findOne(id);
		beanMapper.map(productInDTO, productEntity);
		return createProductDTO(productDAO.save(productEntity));
	}

	@Override
	public void delete(Integer id) {
		ProductEntity productEntity = productDAO.findOne(id);
		productDAO.delete(productEntity);
	}

	public List<ProductDTO> createProductDTOs(List<ProductEntity> productEntities) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (ProductEntity productEntity : productEntities) {
			productDTOs.add(createProductDTO(productEntity));
		}
		return productDTOs;
	}

	@Override
	public ProductDTO createProductDTO(ProductEntity productEntity) {
		return beanMapper.map(productEntity, ProductDTO.class);
	}

	public ProductEntity createProductEntity(ProductInDTO productInDTO) {
		return beanMapper.map(productInDTO, ProductEntity.class);
	}

}

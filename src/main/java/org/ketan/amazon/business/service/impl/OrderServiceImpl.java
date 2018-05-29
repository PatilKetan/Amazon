package org.ketan.amazon.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ketan.amazon.business.dto.CustomerDTO;
import org.ketan.amazon.business.dto.OrderDTO;
import org.ketan.amazon.business.dto.OrderInDTO;
import org.ketan.amazon.business.dto.ProductDTO;
import org.ketan.amazon.business.mapper.DozerBeanMapper;
import org.ketan.amazon.business.service.CustomerService;
import org.ketan.amazon.business.service.OrderService;
import org.ketan.amazon.business.service.ProductService;
import org.ketan.amazon.persistence.dao.CustomerDAO;
import org.ketan.amazon.persistence.dao.OrderDAO;
import org.ketan.amazon.persistence.dao.ProductDAO;
import org.ketan.amazon.persistence.db.CustomerEntity;
import org.ketan.amazon.persistence.db.OrderEntity;
import org.ketan.amazon.persistence.db.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private DozerBeanMapper beanMapper;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Override
	public OrderDTO save(OrderInDTO orderInDTO) {

		ProductEntity productEntity = productDAO.findOne(orderInDTO.getProductId());
		CustomerEntity customerEntity = customerDAO.findOne(orderInDTO.getCustomerId());

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomerEntity(customerEntity);
		orderEntity.setProductEntity(productEntity);

		orderEntity = orderDAO.save(orderEntity);

		return createOrderDTO(orderEntity);
	}

	@Override
	public List<OrderDTO> findAll() {
		List<OrderEntity> orderEntities = orderDAO.findAll();
		return createOrderDTOs(orderEntities);
	}

	@Override
	public OrderDTO findOne(Integer id) {
		OrderEntity orderEntity = orderDAO.findOne(id);
		return createOrderDTO(orderEntity);
	}

	@Override
	public OrderDTO update(Integer id, OrderInDTO orderInDTO) {
		OrderEntity orderEntity = orderDAO.findOne(id);
		beanMapper.map(orderInDTO, orderEntity);
		return createOrderDTO(orderEntity);
	}

	@Override
	public void delete(Integer id) {
		OrderEntity orderEntity = orderDAO.findOne(id);
		orderDAO.delete(orderEntity);
	}

	public List<OrderDTO> createOrderDTOs(List<OrderEntity> orderEntities) {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for (OrderEntity orderEntity : orderEntities) {
			orderDTOs.add(createOrderDTO(orderEntity));
		}
		return orderDTOs;
	}

	public OrderDTO createOrderDTO(OrderEntity orderEntity) {
		OrderDTO orderDTO = beanMapper.map(orderEntity, OrderDTO.class);

		CustomerDTO customerDTO = customerService.createCustomerDTO(orderEntity.getCustomerEntity());
		ProductDTO productDTO = productService.createProductDTO(orderEntity.getProductEntity());

		orderDTO.setCustomerDTO(customerDTO);
		orderDTO.setProductDTO(productDTO);

		return orderDTO;
	}

	public OrderEntity createOrderEntity(OrderInDTO orderInDTO) {
		return beanMapper.map(orderInDTO, OrderEntity.class);
	}

}

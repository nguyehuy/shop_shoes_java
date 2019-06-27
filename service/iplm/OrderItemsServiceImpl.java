package com.huynguyen.service.iplm;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynguyen.dao.OrderDao;
import com.huynguyen.dao.OrderItemsDao;
import com.huynguyen.dao.ProductDao;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.OrderItems;
import com.huynguyen.model.OrderDTO;
import com.huynguyen.model.OrderItemsDTO;
import com.huynguyen.service.OrderItemsService;
import com.huynguyen.service.OrderService;
import com.huynguyen.service.ProductService;

@Service
@Transactional
public class OrderItemsServiceImpl implements OrderItemsService {

	@Autowired
	OrderItemsDao orderItemsDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductService productService;
	
	public void addOrderItems (OrderItemsDTO orderItemsDTO) {

		OrderItems orderItem=new OrderItems();
		orderItem.setNumber(orderItemsDTO.getNumber());
		orderItem.setPrice(orderItemsDTO.getPrice());
		orderItem.setProduct(productDao.getProductById(orderItemsDTO.getProductDTO().getId()));
		orderItem.setOrder(orderDao.getOrderById(orderItemsDTO.getOrderDTO().getId()));
		//orderItem.setOrder(orderDao.getOrderById(orderItemsDTO.getOrderDTO().getId()));
		
		orderItemsDao.addOrderItems(orderItem);

	}

	public void updateOrderItems (OrderItemsDTO orderItemsDTO) {

		OrderItems orderItem=orderItemsDao.getOrderItemsById(orderItemsDTO.getId());
		if (orderItem != null) {
			orderItem.setNumber(orderItemsDTO.getNumber());
			orderItem.setPrice(orderItemsDTO.getPrice());
			orderItem.setProduct(productDao.getProductById(orderItemsDTO.getProductDTO().getId()));
			orderItem.setOrder(orderDao.getOrderById(orderItemsDTO.getOrderDTO().getId()));
			//orderItem.setOrder(orderDao.getOrderById(orderItemsDTO.getOrderDTO().getId()));
			orderItemsDao.updateOrderItems(orderItem);
		}

	}

	public void deleteOrderItems(int id) {
		OrderItems orderItem=orderItemsDao.getOrderItemsById(id);
		if (orderItem != null) {
			orderItemsDao.deleteOrderItems(id);
		}

	}

	public OrderItemsDTO getOrderItemsById(int id) {
		OrderItems orderItem=orderItemsDao.getOrderItemsById(id);
		if (orderItem != null) {
			OrderItemsDTO orderItemsDTO=new OrderItemsDTO();
			orderItemsDTO.setId(orderItem.getId());
			orderItemsDTO.setNumber(orderItem.getNumber());
			orderItemsDTO.setPrice(orderItem.getPrice());
			orderItemsDTO.setOrderDTO(orderService.getOrderById(orderItem.getOrder().getId()));
			orderItemsDTO.setProductDTO(productService.getProductById(orderItem.getProduct().getId()));
			//orderItemsDTO.getOrderDTO()
			return orderItemsDTO;
		}
		return null;
	}

	public List<OrderItemsDTO> getAll() {
		List<OrderItems> orderItems = orderItemsDao.getAll();
		if (orderItems != null) {
			List<OrderItemsDTO> orderItemsDTOs = new ArrayList<OrderItemsDTO>();
			for (OrderItems orderItems1 : orderItems) {
				OrderItemsDTO orderItemsDTO=new OrderItemsDTO();
				orderItemsDTO.setId(orderItems1.getId());
				orderItemsDTO.setNumber(orderItems1.getNumber());
				orderItemsDTO.setPrice(orderItems1.getPrice());
				orderItemsDTO.setOrderDTO(orderService.getOrderById(orderItems1.getId()));
				orderItemsDTO.setProductDTO(productService.getProductById(orderItems1.getProduct().getId()));
				orderItemsDTOs.add(orderItemsDTO);
			}
			return orderItemsDTOs;
		}
		return null;
	}

	
}

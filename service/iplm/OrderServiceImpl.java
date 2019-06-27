package com.huynguyen.service.iplm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynguyen.dao.OrderDao;
import com.huynguyen.dao.OrderItemsDao;
import com.huynguyen.dao.ProductDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.OrderItems;
import com.huynguyen.model.OrderDTO;
import com.huynguyen.model.OrderItemsDTO;
import com.huynguyen.service.OrderItemsService;
import com.huynguyen.service.OrderService;
import com.huynguyen.service.ProductService;
import com.huynguyen.service.UserService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	UserService userService;

	@Autowired
	UserDao userDao;

	@Autowired
	OrderItemsService orderItemsService;

	@Autowired
	OrderItemsDao orderItemsDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	ProductService productService;

	public void addOrder(OrderDTO orderDTO) {
		try {
			Order order = new Order();
			order.setTransaction_id(orderDTO.getTransaction_id());
			order.setStatus(orderDTO.isStatus());
			order.setUser(userDao.getUserById(orderDTO.getUserDTO().getId()));

			List<OrderItems> list = new ArrayList<OrderItems>();
			List<OrderItemsDTO> orderItemsDTOs = orderDTO.getItemsDTOs();
			for (OrderItemsDTO orderItemsDTO : orderItemsDTOs) {
				OrderItems orderItems = new OrderItems();
				orderItems.setNumber(orderItemsDTO.getNumber());
				orderItems.setOrder(orderDao.getOrderById(orderDTO.getId()));
				orderItems.setPrice(orderItemsDTO.getPrice());
				orderItems.setProduct(productDao.getProductById(orderItemsDTO.getProductDTO().getId()));
				list.add(orderItems);
			}
			order.setOrderItems(list);
			orderDao.addOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateOrder(OrderDTO orderDTO) {

		Order order = orderDao.getOrderById(orderDTO.getId());
		if (order != null) {
			order.setTransaction_id(orderDTO.getTransaction_id());
			order.setStatus(orderDTO.isStatus());
			order.setUser(userDao.getUserById(orderDTO.getUserDTO().getId()));
			List<OrderItems> list = order.getOrderItems();
			List<OrderItemsDTO> orderItemsDTOs = orderDTO.getItemsDTOs();

			System.out.println(orderItemsDTOs.size());
			for (OrderItemsDTO orderItemsDTO : orderItemsDTOs) {
				// list.add(orderItemsDao.getOrderItemsById(orderItemsDTO.getId()));

				OrderItems orderItems = new OrderItems();
				orderItems.setNumber(orderItemsDTO.getNumber());
				orderItems.setOrder(orderDao.getOrderById(orderDTO.getId()));
				orderItems.setPrice(orderItemsDTO.getPrice());
				orderItems.setProduct(productDao.getProductById(orderItemsDTO.getProductDTO().getId()));
				if (Arrays.asList(list).contains(orderItems)) {
					list.add(orderItems);
				}
				
				// System.out.println(orderItemsDTO.getId());
			}
			System.out.println(list.size());
			order.setOrderItems(list);
			
			orderDao.updateOrder(order);
		}

	}

	public void deleteOrder(int id) {
		Order order = orderDao.getOrderById(id);
		if (order != null) {
			orderDao.deleteOrder(id);
		}

	}

	public OrderDTO getOrderById(int id) {
		Order order = orderDao.getOrderById(id);
		if (order != null) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(order.getId());
			orderDTO.setUserDTO(userService.getUserById(order.getUser().getId()));
			orderDTO.setTransaction_id(order.getTransaction_id());
			orderDTO.setStatus(order.isStatus());

			List<OrderItemsDTO> orderItemsDTOs = new ArrayList<OrderItemsDTO>();
			List<OrderItems> list = order.getOrderItems();
			for (OrderItems orderItems : list) {
				// orderItemsDTOs.add(orderItemsService.getOrderItemsById(orderItems.getId()));
				OrderItemsDTO dto = new OrderItemsDTO();
				dto.setId(orderItems.getId());
				dto.setNumber(orderItems.getNumber());
				dto.setProductDTO(productService.getProductById(orderItems.getProduct().getId()));
				dto.setPrice(orderItems.getPrice());
				orderItemsDTOs.add(dto);
			}
			orderDTO.setItemsDTOs(orderItemsDTOs);
			return orderDTO;
		}
		return null;
	}

	public List<OrderDTO> getAll() {
		List<Order> orders = orderDao.getAll();
		if (orders != null) {
			List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
			for (Order order : orders) {
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setId(order.getId());
				orderDTO.setTransaction_id(order.getTransaction_id());
				orderDTO.setUserDTO(userService.getUserById(order.getUser().getId()));
				orderDTO.setStatus(order.isStatus());
				List<OrderItemsDTO> orderItemsDTOs = new ArrayList<OrderItemsDTO>();
				List<OrderItems> list = order.getOrderItems();
				for (OrderItems orderItems : list) {
					OrderItemsDTO dto = new OrderItemsDTO();
					dto.setId(orderItems.getId());
					dto.setNumber(orderItems.getNumber());
					dto.setProductDTO(productService.getProductById(orderItems.getProduct().getId()));
					dto.setPrice(orderItems.getPrice());
					orderItemsDTOs.add(dto);
				}
				orderDTO.setItemsDTOs(orderItemsDTOs);
				orderDTOs.add(orderDTO);
			}
			return orderDTOs;
		}
		return null;
	}

	public OrderDTO getOrderByUser(int id) {
		Order order = orderDao.getOrderByUser(id);
		if (order != null) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(order.getId());
			orderDTO.setUserDTO(userService.getUserById(order.getUser().getId()));
			orderDTO.setTransaction_id(order.getTransaction_id());
			orderDTO.setStatus(order.isStatus());

			List<OrderItemsDTO> orderItemsDTOs = new ArrayList<OrderItemsDTO>();
			List<OrderItems> list = order.getOrderItems();
			for (OrderItems orderItems : list) {
				OrderItemsDTO dto = new OrderItemsDTO();
				dto.setId(orderItems.getId());
				dto.setNumber(orderItems.getNumber());
				dto.setProductDTO(productService.getProductById(orderItems.getProduct().getId()));
				dto.setPrice(orderItems.getPrice());
				orderItemsDTOs.add(dto);
			}
			orderDTO.setItemsDTOs(orderItemsDTOs);
			return orderDTO;
		}

		return null;
	}

	public OrderDTO getOrderByUserAndStt(int id) {
		Order order = orderDao.getOrderByUserAndStt(id);
		if (order != null) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(order.getId());
			orderDTO.setUserDTO(userService.getUserById(order.getUser().getId()));
			orderDTO.setTransaction_id(order.getTransaction_id());
			orderDTO.setStatus(order.isStatus());

			List<OrderItemsDTO> orderItemsDTOs = new ArrayList<OrderItemsDTO>();
			List<OrderItems> list = order.getOrderItems();
			for (OrderItems orderItems : list) {
				OrderItemsDTO dto = new OrderItemsDTO();
				dto.setId(orderItems.getId());
				dto.setNumber(orderItems.getNumber());
				dto.setProductDTO(productService.getProductById(orderItems.getProduct().getId()));
				dto.setPrice(orderItems.getPrice());
				orderItemsDTOs.add(dto);
			}
			orderDTO.setItemsDTOs(orderItemsDTOs);
			return orderDTO;
		}

		return null;
	}

}

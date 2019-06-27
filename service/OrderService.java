package com.huynguyen.service;

import java.util.List;

import com.huynguyen.model.OrderDTO;

public interface OrderService {
	public void addOrder(OrderDTO orderDTO );
	public void updateOrder(OrderDTO orderDTO);
	public void deleteOrder(int id);
	public OrderDTO getOrderById(int id);
	public List<OrderDTO> getAll();
	public OrderDTO getOrderByUser(int id);
	public OrderDTO getOrderByUserAndStt(int id);

}

package com.huynguyen.service;

import java.util.List;

import com.huynguyen.model.CategoryDTO;
import com.huynguyen.model.OrderDTO;
import com.huynguyen.model.OrderItemsDTO;
import com.huynguyen.model.ProductDTO;
import com.huynguyen.model.UserDTO;

public interface OrderItemsService {
	public void addOrderItems (OrderItemsDTO orderItemsDTO );
	public void updateOrderItems (OrderItemsDTO orderItemsDTO);
	public void deleteOrderItems(int id);
	public OrderItemsDTO getOrderItemsById(int id);
	public List<OrderItemsDTO> getAll();

}

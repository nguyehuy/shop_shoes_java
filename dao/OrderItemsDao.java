package com.huynguyen.dao;

import java.util.List;

import com.huynguyen.entity.Category;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.OrderItems;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

public interface OrderItemsDao {

	public void addOrderItems (OrderItems orderItem );
	public void updateOrderItems(OrderItems orderItem);
	public void deleteOrderItems(int id);
	public OrderItems getOrderItemsById(int id);
	public List<OrderItems> getAll();
	
}

package com.huynguyen.dao;

import java.util.List;

import com.huynguyen.entity.Category;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

public interface OrderDao {

	public void addOrder (Order order );
	public void updateOrder(Order order);
	public void deleteOrder(int id);
	public Order getOrderById(int id);
	public List<Order> getAll();
	public Order getOrderByUser(int id);
	public Order getOrderByUserAndStt(int id);
	
}

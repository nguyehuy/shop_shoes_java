package com.huynguyen.dao.iplm;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huynguyen.dao.CategoryDao;
import com.huynguyen.dao.OrderDao;
import com.huynguyen.dao.OrderItemsDao;
import com.huynguyen.dao.ProductDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Category;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.OrderItems;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

@Repository
@Transactional
public class OrderItemsDaoImpl implements OrderItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addOrderItems (OrderItems orderItem ) {
		sessionFactory.getCurrentSession().save(orderItem);

	}

	public void updateOrderItems(OrderItems orderItem) {
		sessionFactory.getCurrentSession().merge(orderItem);

	}

	public void deleteOrderItems(int id) {
		sessionFactory.getCurrentSession().delete(getOrderItemsById(id));

	}

	public OrderItems getOrderItemsById(int id) {
		OrderItems orderItem = (OrderItems) sessionFactory.getCurrentSession().get(OrderItems.class, id);
		if (orderItem != null) {
			return orderItem;
		}
		return null;
	}

	public List<OrderItems> getAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(OrderItems.class);
		if (criteria != null) {
			return criteria.list();
		}
		return null;
	}

	

	
	

	

	

}

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
import com.huynguyen.dao.ProductDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Category;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);

	}

	public void updateOrder(Order order) {
		
		sessionFactory.getCurrentSession().merge(order);

	}

	public void deleteOrder(int id) {
		sessionFactory.getCurrentSession().delete(getOrderById(id));

	}

	public Order getOrderById(int id) {
		Order order = (Order) sessionFactory.getCurrentSession().get(Order.class, id);
		if (order != null) {
			return order;
		}
		return null;
	}

	public List<Order> getAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		if (criteria != null) {
			return criteria.list();
		}
		return null;
	}

	public Order getOrderByUser(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from orderbill where user_id=:user_id");
		query.setParameter("user_id", id);
		Order order = (Order) query.uniqueResult();
		if (order != null) {
			return order;
		}
		return null;
	}

	public Order getOrderByUserAndStt(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from orderbill where user_id =:user_id and sttus =:sttus");
		query.setParameter("user_id", id);
		query.setParameter("sttus", false);
		System.out.println("cccc");
		Order order = (Order) query.uniqueResult();
		if (order != null) {
			return order;
		}
		return null;
	}

}

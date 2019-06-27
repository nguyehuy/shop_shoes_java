package com.huynguyen.dao.iplm;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);

	}

	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(getUserById(id));

	}

	public User getUserById(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		if (user != null) {
			return user;
		}
		return null;
	}

	public List<User> getAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		if (criteria != null) {
			return criteria.list();
		}
		return null;
	}

	public User getUserByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from user where username=:username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		if (user != null) {
			return user;
		}
		return null;
	}

}

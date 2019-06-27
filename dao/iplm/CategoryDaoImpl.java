package com.huynguyen.dao.iplm;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huynguyen.dao.CategoryDao;
import com.huynguyen.dao.ProductDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Category;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addCategory (Category categories ) {
		sessionFactory.getCurrentSession().save(categories);

	}

	public void updateCategory(Category categories) {
		sessionFactory.getCurrentSession().merge(categories);

	}

	public void deleteCategory(int id) {
		sessionFactory.getCurrentSession().delete(getCategoryById(id));

	}

	public Category getCategoryById(int id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
		if (category != null) {
			return category;
		}
		return null;
	}

	public List<Category> getAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		if (criteria != null) {
			return criteria.list();
		}
		return null;
	}

	public Category getCategoryByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from categories where name=:name");
		query.setParameter("name", name);
		Category category = (Category) query.uniqueResult();
		if (category != null) {
			return category;
		}
		return null;
	}

	

	

	

}

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
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CategoryDao categoryDao;

	public void addProduct (Product product ) {
		sessionFactory.getCurrentSession().save(product);

	}

	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().merge(product);

	}

	public void deleteProduct(int id) {
		sessionFactory.getCurrentSession().delete(getProductById(id));

	}

	public Product getProductById(int id) {
		Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, id);
		if (product != null) {
			return product;
		}
		return null;
	}

	public List<Product> getAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		if (criteria != null) {
			return criteria.list();
		}
		return null;
	}

	public Product getProductByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from product where name=:name");
		query.setParameter("name", name);
		Product product = (Product) query.uniqueResult();
		if (product != null) {
			return product;
		}
		return null;
	}

	public List<Product> getProductByCategory(String category) {
		int i=categoryDao.getCategoryByName(category).getId();
		
		
		Query query = sessionFactory.getCurrentSession().createQuery("from product where catalog_id=:catalog_id");
		query.setLong("catalog_id", i);
		List<Product> products = (List<Product>) query.list();
		if (products != null) {
			return products;
		}
		return null;
	}

}

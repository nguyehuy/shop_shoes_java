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
import com.huynguyen.dao.TransactionDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Category;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.Transaction;
import com.huynguyen.entity.User;

@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addTransaction (Transaction transaction ) {
		sessionFactory.getCurrentSession().save(transaction);

	}

	public void updateTransaction(Transaction transaction) {
		sessionFactory.getCurrentSession().merge(transaction);

	}

	public void deleteTransaction(int id) {
		sessionFactory.getCurrentSession().delete(getTransactionById(id));

	}

	public Transaction getTransactionById(int id) {
		Transaction transaction = (Transaction) sessionFactory.getCurrentSession().get(Transaction.class, id);
		if (transaction != null) {
			return transaction;
		}
		return null;
	}

	public List<Transaction> getAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Transaction.class);
		if (criteria != null) {
			return criteria.list();
		}
		return null;
	}

	public Transaction getTransactionByUser(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from transaction where user_id=:user_id");
		query.setParameter("user_id", id);
		Transaction transaction = (Transaction) query.uniqueResult();
		if (transaction != null) {
			return transaction;
		}
		return null;
	}

	public Transaction getTransactionByUserAndStt(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from transaction where user_id=:user_id and sttus =:sttus");
		query.setParameter("user_id", id);
		query.setParameter("sttus", false);
		Transaction transaction = (Transaction) query.uniqueResult();
		if (transaction != null) {
			return transaction;
		}
		return null;
	}

	

	

	

}

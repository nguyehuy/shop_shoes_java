package com.huynguyen.service.iplm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.huynguyen.model.TransactionDTO;
import com.huynguyen.model.UserDTO;
import com.huynguyen.service.TransactionService;

@Repository
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	@Autowired
	UserDao userDao;
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public void addTransaction(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		transaction.setSttus(transactionDTO.isSttus());
		transaction.setUser(userDao.getUserById(transactionDTO.getUser_id()));
		transaction.setUser_name(transactionDTO.getUser_name());
		transaction.setUser_phone(transactionDTO.getUser_phone());
		transaction.setTotal_money(Integer.parseInt(transactionDTO.getTotal_money()));
		transaction.setPayment(transactionDTO.getPayment());
		transaction.setPayment_info(transactionDTO.getPayment_info());
		transaction.setMessage(transactionDTO.getMessage());
		if (transactionDTO.getSecurity()!=null) {
			transaction.setSecurity(Integer.parseInt(transactionDTO.getSecurity()));
		}
		

		transaction.setCreated(new Date());

		transaction.setUser_address(transactionDTO.getUser_address());
		transactionDao.addTransaction(transaction);

	}

	public void updateTransaction(TransactionDTO transactionDTO) {
		Transaction transaction = transactionDao.getTransactionById(transactionDTO.getId());
		if (transaction != null) {
			transaction.setSttus(transactionDTO.isSttus());
			transaction.setUser(userDao.getUserById(transactionDTO.getUser_id()));
			transaction.setUser_name(transactionDTO.getUser_name());
			transaction.setUser_phone(transactionDTO.getUser_phone());
			transaction.setTotal_money(Integer.parseInt(transactionDTO.getTotal_money()));
			transaction.setPayment(transactionDTO.getPayment());
			transaction.setPayment_info(transactionDTO.getPayment_info());
			transaction.setMessage(transactionDTO.getMessage());
			transaction.setSecurity(Integer.parseInt(transactionDTO.getSecurity()));
			transaction.setCreated(new Date());
			transaction.setUser_address(transactionDTO.getUser_address());
			transactionDao.updateTransaction(transaction);
		}

	}

	public void deleteTransaction(int id) {
		Transaction transaction = transactionDao.getTransactionById(id);
		if (transaction != null) {
			transactionDao.deleteTransaction(id);
		}

	}

	public TransactionDTO getTransactionById(int id) {
		Transaction transaction = transactionDao.getTransactionById(id);
		TransactionDTO transactionDTO = new TransactionDTO();
		if (transaction != null) {
			transactionDTO.setId(transaction.getId());
			transactionDTO.setSttus(transaction.isSttus());
			transactionDTO.setUser_id(transaction.getUser().getId());
			transactionDTO.setUser_name(transaction.getUser_name());
			transactionDTO.setUser_phone(transaction.getUser_phone());
			transactionDTO.setTotal_money(Integer.toString(transaction.getTotal_money()));
			transactionDTO.setPayment(transaction.getPayment());
			transactionDTO.setPayment_info(transaction.getPayment_info());
			transactionDTO.setMessage(transaction.getMessage());
			transactionDTO.setSecurity(Integer.toString(transaction.getSecurity()));

			transactionDTO.setCreated(format.format(transaction.getCreated()));

			transactionDTO.setUser_address(transaction.getUser_address());
		}
		return transactionDTO;
	}

	public List<TransactionDTO> getAll() {
		List<Transaction> transactions = transactionDao.getAll();
		List<TransactionDTO> transactionDTOs = new ArrayList<TransactionDTO>();
		if (transactions != null) {

			for (Transaction transaction : transactions) {
				TransactionDTO transactionDTO = new TransactionDTO();
				transactionDTO.setId(transaction.getId());
				transactionDTO.setSttus(transaction.isSttus());
				transactionDTO.setUser_id(transaction.getUser().getId());
				transactionDTO.setUser_name(transaction.getUser_name());
				transactionDTO.setUser_phone(transaction.getUser_phone());
				transactionDTO.setTotal_money(Integer.toString(transaction.getTotal_money()));
				transactionDTO.setPayment(transaction.getPayment());
				transactionDTO.setPayment_info(transaction.getPayment_info());
				transactionDTO.setMessage(transaction.getMessage());
				transactionDTO.setSecurity(Integer.toString(transaction.getSecurity()));

				transactionDTO.setCreated(format.format(transaction.getCreated()));

				transactionDTO.setUser_address(transaction.getUser_address());
				transactionDTOs.add(transactionDTO);
			}
		}
		return transactionDTOs;
	}

	public TransactionDTO getTransactionByUser(int id) {
		Transaction transaction = transactionDao.getTransactionByUser(id);
		TransactionDTO transactionDTO = new TransactionDTO();
		if (transaction != null) {
			transactionDTO.setId(transaction.getId());
			

			transactionDTO.setSttus(transaction.isSttus());
			transactionDTO.setUser_id(transaction.getUser().getId());
			
			transactionDTO.setUser_name(transaction.getUser_name());
			transactionDTO.setUser_phone(transaction.getUser_phone());
			transactionDTO.setTotal_money(Integer.toString(transaction.getTotal_money()));
			transactionDTO.setPayment(transaction.getPayment());
			transactionDTO.setPayment_info(transaction.getPayment_info());
			transactionDTO.setMessage(transaction.getMessage());
			transactionDTO.setSecurity(Integer.toString(transaction.getSecurity()));

			transactionDTO.setCreated(format.format(transaction.getCreated()));

			transactionDTO.setUser_address(transaction.getUser_address());
		}

		return transactionDTO;
	}

	public TransactionDTO getTransactionByUserAndStt(int id) {
		Transaction transaction = transactionDao.getTransactionByUserAndStt(id);
		TransactionDTO transactionDTO = new TransactionDTO();
		if (transaction != null) {
			transactionDTO.setId(transaction.getId());
			

			transactionDTO.setSttus(transaction.isSttus());
			transactionDTO.setUser_id(transaction.getUser().getId());
			
			transactionDTO.setUser_name(transaction.getUser_name());
			transactionDTO.setUser_phone(transaction.getUser_phone());
			transactionDTO.setTotal_money(Integer.toString(transaction.getTotal_money()));
			transactionDTO.setPayment(transaction.getPayment());
			transactionDTO.setPayment_info(transaction.getPayment_info());
			transactionDTO.setMessage(transaction.getMessage());
			transactionDTO.setSecurity(Integer.toString(transaction.getSecurity()));

			transactionDTO.setCreated(format.format(transaction.getCreated()));

			transactionDTO.setUser_address(transaction.getUser_address());
		}

		return transactionDTO;
	}

	

}

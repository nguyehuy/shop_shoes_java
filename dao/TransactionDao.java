package com.huynguyen.dao;

import java.util.List;

import com.huynguyen.entity.Category;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.Transaction;
import com.huynguyen.entity.User;

public interface TransactionDao {

	public void addTransaction (Transaction transaction );
	public void updateTransaction(Transaction transaction);
	public void deleteTransaction(int id);
	public Transaction getTransactionById(int id);
	public Transaction getTransactionByUser(int id);
	public List<Transaction> getAll();
	public Transaction getTransactionByUserAndStt(int id);
}

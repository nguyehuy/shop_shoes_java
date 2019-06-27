package com.huynguyen.service;

import java.util.List;

import com.huynguyen.entity.Category;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.Transaction;
import com.huynguyen.entity.User;
import com.huynguyen.model.TransactionDTO;

public interface TransactionService {

	public void addTransaction (TransactionDTO transactionDTO );
	public void updateTransaction(TransactionDTO transactionDTO);
	public void deleteTransaction(int id);
	public TransactionDTO getTransactionById(int id);
	public TransactionDTO getTransactionByUser(int id);
	public List<TransactionDTO> getAll();
	public TransactionDTO getTransactionByUserAndStt(int id);
}

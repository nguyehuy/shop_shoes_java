package com.huynguyen.dao;

import java.util.List;

import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

public interface ProductDao {

	public void addProduct (Product product );
	public void updateProduct(Product product);
	public void deleteProduct(int id);
	public Product getProductById(int id);
	public Product getProductByName(String name);
	public List<Product> getAll();
	public List<Product> getProductByCategory(String category);
}

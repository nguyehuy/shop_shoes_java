package com.huynguyen.dao;

import java.util.List;

import com.huynguyen.entity.Category;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;

public interface CategoryDao {

	public void addCategory (Category categories );
	public void updateCategory(Category categories);
	public void deleteCategory(int id);
	public Category getCategoryById(int id);
	public Category getCategoryByName(String name);
	public List<Category> getAll();
	
}

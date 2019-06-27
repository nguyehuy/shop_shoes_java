package com.huynguyen.service;

import java.util.List;

import com.huynguyen.model.CategoryDTO;
import com.huynguyen.model.ProductDTO;
import com.huynguyen.model.UserDTO;

public interface CategoryService {
	public void addCategory(CategoryDTO categoryDTO);
	public void updateCategory(CategoryDTO categoryDTO);
	public void deleteCategory(int id);
	public CategoryDTO getCategoryById(int id);
	public CategoryDTO getCategoryByName(String name);
	public List<CategoryDTO> getAll();

}

package com.huynguyen.service.iplm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynguyen.dao.CategoryDao;
import com.huynguyen.dao.ProductDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Category;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;
import com.huynguyen.model.CategoryDTO;
import com.huynguyen.model.ProductDTO;
import com.huynguyen.model.UserDTO;
import com.huynguyen.service.CategoryService;
import com.huynguyen.service.ProductService;
import com.huynguyen.service.UserService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public void addCategory(CategoryDTO categoryDTO) {

		Category category = new Category();
		category.setName(categoryDTO.getName());
	    category.setManufacture(categoryDTO.getManufacture());
		categoryDao.addCategory(category);

	}

	public void updateCategory(CategoryDTO categoryDTO) {
		
			Category category = categoryDao.getCategoryById(categoryDTO.getId());
			if (category != null) {
				category.setName(categoryDTO.getName());
				category.setManufacture(categoryDTO.getManufacture());
				categoryDao.updateCategory(category);
			}
		

	}

	public void deleteCategory(int id) {
		Category category = categoryDao.getCategoryById(id);
		if (category != null) {
			categoryDao.deleteCategory(id);
		}

	}

	public CategoryDTO getCategoryById(int id) {
		Category category = categoryDao.getCategoryById(id);
		if (category != null) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setName(categoryDTO.getName());
			categoryDTO.setManufacture(category.getManufacture());
			return categoryDTO;
		}
		return null;
	}

	public List<CategoryDTO> getAll() {
		List<Category> categories = categoryDao.getAll();
		if (categories != null) {
			List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
			for (Category category : categories) {
				CategoryDTO categoryDTO = new CategoryDTO();
				categoryDTO.setName(category.getName());
				categoryDTO.setManufacture(category.getManufacture());
				categoryDTOs.add(categoryDTO);
			}
			return categoryDTOs;
		}
		return null;
	}

	public CategoryDTO getCategoryByName(String name) {
		Category category = categoryDao.getCategoryByName(name); 
		if (category != null) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setName(category.getName());
			categoryDTO.setManufacture(category.getManufacture());
			return categoryDTO;
		}
		return null;
	}

	

	

	
}

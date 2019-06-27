package com.huynguyen.service;

import java.util.List;

import com.huynguyen.model.ProductDTO;
import com.huynguyen.model.UserDTO;

public interface ProductService {
	public void addProduct(ProductDTO productDTO);
	public void updateProduct(ProductDTO productDTO);
	public void deleteProduct(int id);
	public ProductDTO getProductById(int id);
	public ProductDTO getProductByName(String name);
	public List<ProductDTO> getAll();
	public List<ProductDTO> getProductByCategory(String category);

}

package com.huynguyen.service.iplm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynguyen.dao.ProductDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.User;
import com.huynguyen.model.ProductDTO;
import com.huynguyen.model.UserDTO;
import com.huynguyen.service.ProductService;
import com.huynguyen.service.UserService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public void addProduct(ProductDTO productDTO) {

		Product product = new Product();
		product.setName(productDTO.getName());
		//product.setCatalog_id(Integer.parseInt(productDTO.getCatalog_id()));
		product.setPrice(Integer.parseInt(productDTO.getPrice()));
		product.setDiscount(Integer.parseInt(productDTO.getDiscount()));
		product.setImage_link(productDTO.getImage_link());
		product.setImage_list(productDTO.getImage_list());
		product.setView(1);
		productDao.addProduct(product);

	}

	public void updateProduct(ProductDTO productDTO) {
		
			Product product = productDao.getProductById(productDTO.getId());
			if (product != null) {
				product.setName(productDTO.getName());
				//product.setCatalog_id(Integer.parseInt(productDTO.getCatalog_id()));
				product.setPrice(Integer.parseInt(productDTO.getPrice()));
				product.setDiscount(Integer.parseInt(productDTO.getDiscount()));
				product.setImage_link(productDTO.getImage_link());
				product.setImage_list(productDTO.getImage_list());
				product.setView(1);
				productDao.updateProduct(product);
			}
		

	}

	public void deleteProduct(int id) {
		Product product = productDao.getProductById(id);
		if (product != null) {
			productDao.deleteProduct(id);
		}

	}

	public ProductDTO getProductById(int id) {
		Product product = productDao.getProductById(id);
		if (product != null) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			//productDTO.setCatalog_id(Integer.toString(product.getCatalog_id()));
			productDTO.setPrice(Integer.toString(product.getPrice()));
			productDTO.setDiscount(Integer.toString(product.getDiscount()));
			productDTO.setImage_link(product.getImage_link());
			productDTO.setImage_list(product.getImage_list());
			productDTO.setView(Integer.toString(product.getView()));
			return productDTO;
		}
		return null;
	}

	public List<ProductDTO> getAll() {
		List<Product> products = productDao.getAll();
		if (products != null) {
			List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
			for (Product product : products) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				//productDTO.setCatalog_id(Integer.toString(product.getCatalog_id()));
				productDTO.setPrice(Integer.toString(product.getPrice()));
				productDTO.setDiscount(Integer.toString(product.getDiscount()));
				productDTO.setImage_link(product.getImage_link());
				productDTO.setImage_list(product.getImage_list());
				productDTO.setView(Integer.toString(product.getView()));
				productDTOs.add(productDTO);
			}
			return productDTOs;
		}
		return null;
	}

	public ProductDTO getProductByName(String name) {
		Product product = productDao.getProductByName(name); 
		if (product != null) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			//productDTO.setCatalog_id(Integer.toString(product.getCatalog_id()));
			productDTO.setPrice(Integer.toString(product.getPrice()));
			productDTO.setDiscount(Integer.toString(product.getDiscount()));
			productDTO.setImage_link(product.getImage_link());
			productDTO.setImage_list(product.getImage_list());
			productDTO.setView(Integer.toString(product.getView()));
			return productDTO;
		}
		return null;
	}

	public List<ProductDTO> getProductByCategory(String category) {
		List<Product> products = productDao.getProductByCategory(category);
		if (products != null) {
			List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
			for (Product product : products) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				//productDTO.setCatalog_id(Integer.toString(product.getCatalog_id()));
				productDTO.setPrice(Integer.toString(product.getPrice()));
				productDTO.setDiscount(Integer.toString(product.getDiscount()));
				productDTO.setImage_link(product.getImage_link());
				productDTO.setImage_list(product.getImage_list());
				productDTO.setView(Integer.toString(product.getView()));
				productDTOs.add(productDTO);
			}
			return productDTOs;
		}
		return null;
	}
}

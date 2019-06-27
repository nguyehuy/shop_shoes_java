package com.huynguyen.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.huynguyen.dao.CategoryDao;
import com.huynguyen.dao.OrderDao;
import com.huynguyen.dao.OrderItemsDao;
import com.huynguyen.dao.ProductDao;
import com.huynguyen.entity.Category;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.OrderItems;
import com.huynguyen.entity.Category;
import com.huynguyen.entity.Product;
import com.huynguyen.model.ProductDTO;
import com.huynguyen.service.CategoryService;
import com.huynguyen.service.ProductService;

import javassist.expr.NewArray;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	

	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemsDao orderItemDao;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		List<ProductDTO> productDTOs=  productService.getAll();
		String error= (String) request.getAttribute("error");
		String error1= (String) request.getAttribute("error1");
		System.out.println(error);
		request.setAttribute("error", error); 
		request.setAttribute("error1", error1); 
		request.setAttribute("list", productDTOs);
		return "index";
	}
	
	
	@RequestMapping(value="/shop/{category}", method=RequestMethod.GET)
	public String shop(HttpServletRequest request,@PathVariable(name="category") String category) {
		
		List<ProductDTO> p=productService.getProductByCategory(category);
		request.setAttribute("number", p.size()/4+1);
		request.setAttribute("categories", p);
		
		
		
		
		return "shop";
	}
	
	@RequestMapping(value="/shop1", method=RequestMethod.GET)
	public String shop1(HttpServletRequest request) {
		Order order=orderDao.getOrderById(4);
		
		OrderItems orderItems=new OrderItems();
//		List<OrderItems> list=new ArrayList<OrderItems>();
//		
//		
//		order.setTransaction_id(3);
//		order.setStatus(true);
		
		orderItems.setNumber(1);
		orderItems.setPrice(500);
		
		
//		list.add(orderItems);
//		order.setOrderItems(list);
		orderItems.setOrder(order);
		//orderDao.addOrder(order);
		orderItems.setProduct(productDao.getProductById(10));
		orderItemDao.addOrderItems(orderItems);
		return "shop";
	}
	

}

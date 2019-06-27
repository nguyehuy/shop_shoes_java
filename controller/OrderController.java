package com.huynguyen.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huynguyen.dao.OrderDao;
import com.huynguyen.dao.OrderItemsDao;
import com.huynguyen.dao.ProductDao;
import com.huynguyen.dao.TransactionDao;
import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.Order;
import com.huynguyen.entity.OrderItems;
import com.huynguyen.entity.Product;
import com.huynguyen.entity.Transaction;
import com.huynguyen.entity.User;
import com.huynguyen.model.OrderDTO;
import com.huynguyen.model.OrderItemsDTO;

import com.huynguyen.model.ProductDTO;
import com.huynguyen.model.TransactionDTO;
import com.huynguyen.model.UserDTO;
import com.huynguyen.service.OrderItemsService;
import com.huynguyen.service.OrderService;
import com.huynguyen.service.ProductService;
import com.huynguyen.service.TransactionService;
import com.huynguyen.service.UserService;

import javassist.expr.NewArray;

@Controller
public class OrderController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductDao productDao;

	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderService orderService;

	@Autowired
	OrderItemsDao orderItemDao;

	@Autowired
	OrderItemsService orderItemsService;

	@Autowired
	UserService userService;

	@Autowired
	UserDao userDao;

	@Autowired
	TransactionDao transactionDao;

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	ProductController productController;
	
	@Autowired
	OrderController orderController;

//	@RequestMapping(value = "/addtocart/{id}", method=RequestMethod.GET)
//	public String addtocart(HttpServletRequest request,@PathVariable(name="id") int id,HttpSession session) {
//		ProductDTO productDTO=productService.getProductById(id);
//		
//		if(session.getAttribute("cart")==null) {
//			OrderDTO orderDTO=new OrderDTO();
//			OrderItemsDTO orderItemsDTO=new OrderItemsDTO();
//			orderItemsDTO.setNumber(1);
//			orderItemsDTO.setPrice(Integer.parseInt(productDTO.getPrice())*orderItemsDTO.getNumber());
//			orderItemsDTO.setProductDTO(productDTO);
//			
//			List<OrderItemsDTO> orderItemsDTOs=new ArrayList<OrderItemsDTO>();
//			orderItemsDTOs.add(orderItemsDTO);
//			orderDTO.setItemsDTOs(orderItemsDTOs);
//			
//			session.setAttribute("cart", orderDTO);
//			request.setAttribute("order", orderDTO);
//		}else {
//			OrderDTO orderDTO=(OrderDTO) session.getAttribute("cart");
//			List<OrderItemsDTO> itemsDTOs=orderDTO.getItemsDTOs(); 
//			boolean flag=true;
//		    for (OrderItemsDTO orderItemsDTO : itemsDTOs) {
//		    	
//				if(orderItemsDTO.getProductDTO().getId()==id) {
//					orderItemsDTO.setNumber(orderItemsDTO.getNumber()+1);
//					orderItemsDTO.setPrice(Integer.parseInt(productDTO.getPrice())*orderItemsDTO.getNumber());
//					flag=false;
//					
//				}
//			}
//		    if(flag) {
//		    	OrderItemsDTO itemsDTO=new OrderItemsDTO();
//		    	itemsDTO.setNumber(1);
//		    	itemsDTO.setPrice(Integer.parseInt(productDTO.getPrice())*itemsDTO.getNumber());
//		    	itemsDTO.setProductDTO(productDTO);
//		    	
//		    	itemsDTOs.add(itemsDTO);
//		    	orderDTO.setItemsDTOs(itemsDTOs);
//		    	
//		    }
//		    session.setAttribute("cart", orderDTO);
//		    request.setAttribute("order", orderDTO);
//		}
//		return "checkout";
//	}
//
//	@RequestMapping(value = "/decrease/{id}", method = RequestMethod.GET)
//	public String decrease(HttpServletRequest request, @PathVariable(name = "id") int id, HttpSession session) {
//		if (session.getAttribute("cart") != null) {
//			ProductDTO productDTO = productService.getProductById(id);
//			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
//			List<OrderItemsDTO> itemsDTOs = orderDTO.getItemsDTOs();
//			Iterator<OrderItemsDTO> iterator = itemsDTOs.iterator();
//			while (iterator.hasNext()) {
//				OrderItemsDTO orderItemsDTO = (OrderItemsDTO) iterator.next();
//				if (orderItemsDTO.getProductDTO().getId() == id) {
//					if (orderItemsDTO.getNumber() > 1) {
//						orderItemsDTO.setNumber(orderItemsDTO.getNumber() - 1);
//						orderItemsDTO.setPrice(Integer.parseInt(productDTO.getPrice()) * orderItemsDTO.getNumber());
//					} else {
//						iterator.remove();
//					}
//				}
//
//			}
//
//			orderDTO.setItemsDTOs(itemsDTOs);
//			session.setAttribute("cart", orderDTO);
//			if (itemsDTOs.isEmpty()) {
//				session.removeAttribute("cart");
//
//			}
//			request.setAttribute("order", orderDTO);
//		}
//		return "checkout";
//	}
//
//	@RequestMapping(value = "/increase/{id}", method = RequestMethod.GET)
//	public String increase(HttpServletRequest request, @PathVariable(name = "id") int id, HttpSession session) {
//		if (session.getAttribute("cart") != null) {
//			ProductDTO productDTO = productService.getProductById(id);
//			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
//			List<OrderItemsDTO> itemsDTOs = orderDTO.getItemsDTOs();
//			Iterator<OrderItemsDTO> iterator = itemsDTOs.iterator();
//			while (iterator.hasNext()) {
//				OrderItemsDTO orderItemsDTO = (OrderItemsDTO) iterator.next();
//				if (orderItemsDTO.getProductDTO().getId() == id) {
//					orderItemsDTO.setNumber(orderItemsDTO.getNumber() + 1);
//					orderItemsDTO.setPrice(Integer.parseInt(productDTO.getPrice()) * orderItemsDTO.getNumber());
//				}
//
//			}
//
//			orderDTO.setItemsDTOs(itemsDTOs);
//			session.setAttribute("cart", orderDTO);
//			if (itemsDTOs.isEmpty()) {
//				session.removeAttribute("cart");
//
//			}
//			request.setAttribute("order", orderDTO);
//		}
//		return "checkout";
//	}
//
//	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
//	public String remove(HttpServletRequest request, @PathVariable(name = "id") int id, HttpSession session) {
//		if (session.getAttribute("cart") != null) {
//			ProductDTO productDTO = productService.getProductById(id);
//			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
//			List<OrderItemsDTO> itemsDTOs = orderDTO.getItemsDTOs();
//			Iterator<OrderItemsDTO> iterator = itemsDTOs.iterator();
//			while (iterator.hasNext()) {
//				OrderItemsDTO orderItemsDTO = (OrderItemsDTO) iterator.next();
//				if (orderItemsDTO.getProductDTO().getId() == id) {
//					iterator.remove();
//				}
//
//			}
//
//			orderDTO.setItemsDTOs(itemsDTOs);
//			session.setAttribute("cart", orderDTO);
//			if (itemsDTOs.isEmpty()) {
//				session.removeAttribute("cart");
//
//			}
//			request.setAttribute("order", orderDTO);
//		}
//		return "checkout";
//	}

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	@ResponseBody
	public String addtocart(HttpServletRequest request, @RequestParam(value = "order[]") List<Integer> order,@RequestParam(value = "price[]") List<Integer> price,@RequestParam(value = "quantity[]") List<Integer> quantity,
			HttpSession session) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {
			// System.out.println(authentication.getName());
			for (int i = 0; i < order.size(); i++) {
				
				ProductDTO productDTO = productService.getProductById(order.get(i));

				UserDTO userDTO = userService.getUserByUsername(authentication.getName());
				

				OrderDTO orderDTO2 = orderService.getOrderByUserAndStt(userDTO.getId());
				System.out.println("aaa");

				if (orderDTO2 == null) {
					System.out.println("th1");

					OrderDTO orderDTO1 = new OrderDTO();

					List<OrderItemsDTO> orderItemss = new ArrayList<OrderItemsDTO>();

					orderDTO1.setItemsDTOs(orderItemss);

					orderDTO1.setStatus(false);
					orderDTO1.setUserDTO(userDTO);
					orderService.addOrder(orderDTO1);
				}
				OrderDTO orderDTO = orderService.getOrderByUserAndStt(userDTO.getId());
				

				List<OrderItemsDTO> itemss = orderDTO.getItemsDTOs();
				if (itemss.size() == 0) {
					OrderItemsDTO orderItemDTO = new OrderItemsDTO();
					orderItemDTO.setNumber(quantity.get(i));

					orderItemDTO.setPrice(price.get(i));

					orderItemDTO.setProductDTO(productDTO);
					orderItemDTO.setOrderDTO(orderDTO);
					itemss.add(orderItemDTO);
					orderItemsService.addOrderItems(orderItemDTO);

				} else {
					boolean flag = true;
					for (OrderItemsDTO orderItems : itemss) {
						if (orderItems.getProductDTO().getId() == order.get(i)) {
							System.out.println("th2");
							orderItems.setNumber(orderItems.getNumber() + quantity.get(i));

							orderItems.setPrice(Integer.parseInt(productDTO.getPrice())+price.get(i));

							orderItems.setProductDTO(productDTO);
							orderItems.setOrderDTO(orderDTO);
							flag = false;
							orderItemsService.updateOrderItems(orderItems);
						}
					}
					if (flag) {
						System.out.println("th3");
						OrderItemsDTO orderItem = new OrderItemsDTO();
						orderItem.setNumber(quantity.get(i));
						orderItem.setPrice(price.get(i));
						orderItem.setProductDTO(productDTO);
						orderItem.setOrderDTO(orderDTO);

						itemss.add(orderItem);
						orderItemsService.addOrderItems(orderItem);
					}
					

				}

				System.out.println("ccccc");

			}
			
		}
		System.out.println("aaaa");
		//return "redirect:/checkout";
		return orderController.checkout(request);
	
	}

	@RequestMapping(value = "/decrease", method = RequestMethod.POST)
	@ResponseBody
	public void decrease(HttpServletRequest request, @RequestParam(name = "id") Integer id, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {

			ProductDTO productDTO = productService.getProductById(id);

			UserDTO userDTO = userService.getUserByUsername(authentication.getName());
			OrderDTO orderDTO = orderService.getOrderByUserAndStt(userDTO.getId());

			if (orderDTO != null) {
				List<OrderItemsDTO> itemsDTOs = orderDTO.getItemsDTOs();
				Iterator<OrderItemsDTO> iterator = itemsDTOs.iterator();
				while (iterator.hasNext()) {
					OrderItemsDTO orderItemsDTO = (OrderItemsDTO) iterator.next();
					if (orderItemsDTO.getProductDTO().getId() == id) {
						if (orderItemsDTO.getNumber() > 1) {
							orderItemsDTO.setNumber(orderItemsDTO.getNumber() - 1);
							orderItemsDTO.setPrice(Integer.parseInt(productDTO.getPrice()) * orderItemsDTO.getNumber());
							orderItemsDTO.setProductDTO(productDTO);
							orderItemsDTO.setOrderDTO(orderDTO);
							orderItemsService.updateOrderItems(orderItemsDTO);
						} else {
							iterator.remove();
							orderItemsService.deleteOrderItems(orderItemsDTO.getId());
						}
					}

				}

				orderDTO.setItemsDTOs(itemsDTOs);

				request.setAttribute("order", orderDTO);
			}
			
		} 
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@ResponseBody
	public void remove(HttpServletRequest request, @RequestParam(name = "id") Integer id, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {

			ProductDTO productDTO = productService.getProductById(id);

			UserDTO userDTO = userService.getUserByUsername(authentication.getName());
			OrderDTO orderDTO = orderService.getOrderByUserAndStt(userDTO.getId());

			if (orderDTO != null) {
				List<OrderItemsDTO> itemsDTOs = orderDTO.getItemsDTOs();
				Iterator<OrderItemsDTO> iterator = itemsDTOs.iterator();
				while (iterator.hasNext()) {
					OrderItemsDTO orderItemsDTO = (OrderItemsDTO) iterator.next();
					if (orderItemsDTO.getProductDTO().getId() == id) {
						iterator.remove();
						orderItemsService.deleteOrderItems(orderItemsDTO.getId());
					}
				}

				orderDTO.setItemsDTOs(itemsDTOs);

				request.setAttribute("order", orderDTO);
			}
			
		} 
	}

	@RequestMapping(value = "/increase", method = RequestMethod.POST)
	@ResponseBody
	public void increase(HttpServletRequest request, @RequestParam(name = "id") Integer id, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {

			ProductDTO productDTO = productService.getProductById(id);

			UserDTO userDTO = userService.getUserByUsername(authentication.getName());
			OrderDTO orderDTO = orderService.getOrderByUserAndStt(userDTO.getId());

			if (orderDTO != null) {
				List<OrderItemsDTO> itemsDTOs = orderDTO.getItemsDTOs();
				Iterator<OrderItemsDTO> iterator = itemsDTOs.iterator();
				while (iterator.hasNext()) {
					OrderItemsDTO orderItemsDTO = (OrderItemsDTO) iterator.next();
					if (orderItemsDTO.getProductDTO().getId() == id) {
						orderItemsDTO.setNumber(orderItemsDTO.getNumber() + 1);
						orderItemsDTO.setPrice(Integer.parseInt(productDTO.getPrice()) * orderItemsDTO.getNumber());
						orderItemsDTO.setProductDTO(productDTO);
						orderItemsDTO.setOrderDTO(orderDTO);
						orderItemsService.updateOrderItems(orderItemsDTO);
					}
				}

				orderDTO.setItemsDTOs(itemsDTOs);

				request.setAttribute("order", orderDTO);
			}
			
		} 
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {
			System.out.println("1");
			UserDTO userDTO = userService.getUserByUsername(authentication.getName());
			OrderDTO orderDTO = orderService.getOrderByUserAndStt(userDTO.getId());
			//System.out.println(orderDTO.getItemsDTOs().size());
			request.setAttribute("order", orderDTO);
			request.setAttribute("transaction", new TransactionDTO());
			return "checkout";

		}else {
			
			request.setAttribute("error1", "error");
			
			
			return productController.index(request);
		}
		

	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(HttpServletRequest request, @ModelAttribute("transaction") TransactionDTO transactionDTO,
			BindingResult bindingResult) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {
			if (bindingResult.hasErrors()) {
				return "redirect:/checkout";
			} else {
				UserDTO userDTO = userService.getUserByUsername(authentication.getName());

				OrderDTO orderDTO = orderService.getOrderByUserAndStt(userDTO.getId());
				TransactionDTO transactionDTO1 = new TransactionDTO();
				transactionDTO1.setSttus(false);
				transactionDTO1.setUser_id(userDTO.getId());

				transactionDTO1.setUser_name(transactionDTO.getUser_name());

				transactionDTO1.setUser_phone(transactionDTO.getUser_phone());
				transactionDTO1.setTotal_money(transactionDTO.getTotal_money());

				transactionDTO1.setMessage(transactionDTO.getMessage());
				transactionDTO1.setUser_address(transactionDTO.getUser_address());
				// transactionDTO1.setPayment("dfsadf");
				// transactionDTO1.setPayment_info("dfasf");
				// transactionDTO1.setSecurity("123");
				transactionService.addTransaction(transactionDTO1);
				request.setAttribute("transaction", transactionDTO1);
				return "payment";
			}

		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/payment/{payment}", method = RequestMethod.POST)
	public String payment(HttpServletRequest request, @PathVariable(name = "payment") String payment) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {

			UserDTO userDTO = userService.getUserByUsername(authentication.getName());
			System.out.println(userDTO.getId());
			TransactionDTO transactionDTO = transactionService.getTransactionByUserAndStt(userDTO.getId());
			System.out.println(transactionDTO.getMessage());
			System.out.println(transactionDTO.getId());
			transactionDTO.setPayment(payment);
			transactionDTO.setPayment_info("Thank you");
			transactionDTO.setSecurity("123");
			transactionDTO.setSttus(true);
			transactionService.updateTransaction(transactionDTO);
			OrderDTO orderDTO = orderService.getOrderByUserAndStt(userDTO.getId());
			orderDTO.setTransaction_id(transactionDTO.getId());
			orderDTO.setStatus(true);

			orderService.updateOrder(orderDTO);
			return "thankyou";
		}
		return "redirect:/";
	}

//	@RequestMapping(value="/addtocart", method=RequestMethod.POST)
//	@ResponseBody
//	public void addtocart(HttpServletRequest request,@RequestParam(value="order[]") Integer[] order, HttpSession session) {   
//		for (Integer integer : order) {
//			System.out.println(integer);
//		}
//	}

}

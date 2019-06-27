package com.huynguyen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {
	@Autowired
	ProductController productController;
	@RequestMapping("/log-in")
	public String Login() {
		System.out.println("aaaaa");
		return "redirect:/";
	}
	// Login fail
	@RequestMapping(value = "/error")
	public String listUser(HttpServletRequest request,@RequestParam("error") String error) {
		
		request.setAttribute("error", error);
		
		return productController.index(request);
	}
	
	@RequestMapping("/log-out")
	public String Logout(HttpServletRequest request,HttpServletResponse response) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/";
	}

}

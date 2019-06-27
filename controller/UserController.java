package com.huynguyen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huynguyen.entity.User;
import com.huynguyen.model.UserDTO;
import com.huynguyen.service.UserService;

@Controller

public class UserController {

	@Autowired
	UserService userService;

	
	
	

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(HttpServletRequest request) {
		request.setAttribute("user", new UserDTO());
		return "register";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(HttpServletRequest request, @ModelAttribute("user") @Valid UserDTO user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "register";
		} else {
			UserDTO userDTO = userService.getUserByUsername(user.getUsername());
			if (userDTO == null) {
				userService.addUser(user);
				return "index";
			} else {
				request.setAttribute("error", "Get another username, please");
				return "register";
			}
		}

	}

	@RequestMapping(value = "/infomation")
	public String infomation(HttpServletRequest request, HttpServletResponse response) {
		org.springframework.security.core.userdetails.User authentication = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		request.setAttribute("user", userService.getUserByUsername(authentication.getUsername()));
		return "infomation";
	}

}

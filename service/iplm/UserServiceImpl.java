package com.huynguyen.service.iplm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynguyen.dao.UserDao;
import com.huynguyen.entity.User;
import com.huynguyen.model.UserDTO;
import com.huynguyen.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public void addUser(UserDTO userDTO) {

		try {
			User user = new User();
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setName(userDTO.getName());
			user.setDateofbirth(format.parse(userDTO.getDateofbirth()));
			user.setAddress(userDTO.getAddress());
			user.setEmail(userDTO.getEmail());
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			userDao.addUser(user);
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	public void updateUser(UserDTO userDTO) {
		try {
			User user = userDao.getUserById(userDTO.getId());
			if (user != null) {
				user.setUsername(userDTO.getUsername());
				user.setPassword(userDTO.getPassword());
				user.setName(userDTO.getName());
				user.setDateofbirth(format.parse(userDTO.getDateofbirth()));
				user.setAddress(userDTO.getAddress());
				user.setEmail(userDTO.getEmail());
				user.setRole("ROLE_ADMIN");
				user.setEnabled(true);
				userDao.addUser(user);
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	public void deleteUser(int id) {
		User user = userDao.getUserById(id);
		if (user != null) {
			userDao.deleteUser(id);
		}

	}

	public UserDTO getUserById(int id) {
		User user = userDao.getUserById(id);
		if (user != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setDateofbirth(format.format(user.getDateofbirth()));
			userDTO.setAddress(user.getAddress());
			userDTO.setEmail(user.getEmail());
			if (user.getRole().equals("ROLE_ADMIN")) {
				userDTO.setRole("ADMIN");
			} else {
				userDTO.setRole("USER");
			}

			if (user.isEnabled()) {
				userDTO.setEnabled("true");
			} else {
				userDTO.setEnabled("false");
			}
			return userDTO;
		}
		return null;
	}

	public List<UserDTO> getAll() {
		List<User> users = userDao.getAll();
		if (users != null) {
			List<UserDTO> userDTOs = new ArrayList<UserDTO>();
			for (User user : users) {
				UserDTO userDTO = new UserDTO();
				userDTO.setId(user.getId());
				userDTO.setName(user.getName());
				userDTO.setDateofbirth(format.format(user.getDateofbirth()));
				userDTO.setAddress(user.getAddress());
				userDTO.setEmail(user.getEmail());
				if (user.getRole().equals("ROLE_ADMIN")) {
					userDTO.setRole("ADMIN");
				} else {
					userDTO.setRole("USER");
				}

				if (user.isEnabled()) {
					userDTO.setEnabled("true");
				} else {
					userDTO.setEnabled("false");
				}
				userDTOs.add(userDTO);
			}
			return userDTOs;
		}
		return null;
	}

	public UserDTO getUserByUsername(String username) {
		User user = userDao.getUserByUsername(username);
		if (user != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setDateofbirth(format.format(user.getDateofbirth()));
			userDTO.setAddress(user.getAddress());
			userDTO.setEmail(user.getEmail());
			if (user.getRole().equals("ROLE_ADMIN")) {
				userDTO.setRole("ADMIN");
			} else {
				userDTO.setRole("USER");
			}

			if (user.isEnabled()) {
				userDTO.setEnabled("true");
			} else {
				userDTO.setEnabled("false");
			}
			return userDTO;
		}
		return null;
	}
}

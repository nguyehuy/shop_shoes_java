package com.huynguyen.service;

import java.util.List;

import com.huynguyen.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO user);
	public void updateUser(UserDTO user);
	public void deleteUser(int id);
	public UserDTO getUserById(int id);
	public UserDTO getUserByUsername(String username);
	public List<UserDTO> getAll();

}

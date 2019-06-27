package com.huynguyen.dao;

import java.util.List;

import com.huynguyen.entity.User;

public interface UserDao {

	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public List<User> getAll();
}

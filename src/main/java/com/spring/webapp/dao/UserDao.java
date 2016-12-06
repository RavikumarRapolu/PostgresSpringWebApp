package com.spring.webapp.dao;

import java.util.List;

import com.spring.webapp.entity.User;

public interface UserDao {

	void add(User user);

	List<User> getAllUsers();

	void update(User user);

	void delete(Long id);

	

	User getUserByEmail(String email);

}

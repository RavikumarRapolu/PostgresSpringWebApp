package com.spring.webapp.service;

import java.util.List;

import com.spring.webapp.entity.User;

public interface UserService {

	void add(User user);

	List<User> getAllUsers();

	void update(User user);

	void delete(Long id);

	
	User getUserByEmail(String email);

}

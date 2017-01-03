package com.spring.webapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webapp.dao.UserDao;
import com.spring.webapp.entity.User;
import com.spring.webapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = false)
	private UserDao userdao;

	public void add(User user) {
		userdao.add(user);

	}

	public List<User> getAllUsers() {

		return userdao.getAllUsers();
	}

	public void update(User user) {
		userdao.update(user);

	}

	public void delete(Long id) {
		userdao.delete(id);

	}

	
	

	
	public User getUserByEmail(String email) {
		
		return userdao.getUserByEmail(email);
	}

}

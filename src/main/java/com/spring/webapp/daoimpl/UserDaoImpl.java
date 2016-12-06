package com.spring.webapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.spring.webapp.dao.UserDao;
import com.spring.webapp.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	private static final Log log = LogFactory.getLog(User.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void add(User user) {
		log.debug(user);
		try {
			entityManager.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> depts = new ArrayList<User>();
		try {
			depts = entityManager.createQuery("Select a From User a", User.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return depts;
	}

	public void update(User user) {
		log.debug(user);
		try {
			entityManager.merge(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Long id) {
		try {
			User user = entityManager.find(User.class, id);
			entityManager.remove(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
//	public boolean login(User user) {
//		 User fetcheduser = this.getUserDetailsByEmail(user.getEmail());
//		 if(fetcheduser.getPassword().equals(user.getPassword())){
//			 return true;
//		 }else
//		 return false;
//	}

	public User getUserByEmail(String email) {
		//User user = entityManager.find(User.class, email);
		 Query query = entityManager.createQuery(
			      "SELECT u FROM User u where u.email = :email");
		 query.setParameter("email", email);
		 User user = (User)query.getSingleResult();
		        
		System.out.println("user  "+user.getEmail());
		return user;
	}

}

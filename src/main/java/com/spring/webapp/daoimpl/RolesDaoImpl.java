package com.spring.webapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.spring.webapp.dao.RolesDao;
import com.spring.webapp.entity.AccountRoles;

@Repository
public class RolesDaoImpl implements RolesDao {
	private static final Log log = LogFactory.getLog(AccountRoles.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void add(AccountRoles role) {
		try {
			entityManager.persist(role);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(Long id) {
		try {
			AccountRoles obj = entityManager.find(AccountRoles.class, id);
			entityManager.remove(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<AccountRoles> getAll() {
		List<AccountRoles> list = new ArrayList<AccountRoles>();
		try {
			list = entityManager.createQuery("Select a From AccountRoles a", AccountRoles.class).getResultList();

			log.debug(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

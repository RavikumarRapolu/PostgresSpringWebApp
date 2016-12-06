package com.spring.webapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webapp.dao.RolesDao;
import com.spring.webapp.entity.AccountRoles;
import com.spring.webapp.service.AccountRoleService;

@Service
public class RolesServiceImpl implements AccountRoleService {
	@Autowired(required = false)
	private RolesDao rolesdao;

	public void add(AccountRoles role) {
		rolesdao.add(role);

	}

	public void delete(Long id) {
		rolesdao.delete(id);

	}

	public List<AccountRoles> getAll() {

		return rolesdao.getAll();
	}

}

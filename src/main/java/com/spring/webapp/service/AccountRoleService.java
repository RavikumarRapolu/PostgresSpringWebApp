package com.spring.webapp.service;

import java.util.List;

import com.spring.webapp.entity.AccountRoles;

public interface AccountRoleService {

	void add(AccountRoles role);

	void delete(Long id);

	List<AccountRoles> getAll();

}

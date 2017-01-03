package com.spring.webapp.dao;

import java.util.List;

import com.spring.webapp.entity.AccountRoles;

public interface RolesDao {

	void add(AccountRoles role);

	void delete(Long id);

	List<AccountRoles> getAll();

}

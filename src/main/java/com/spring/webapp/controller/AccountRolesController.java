package com.spring.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.webapp.entity.AccountRoles;
import com.spring.webapp.service.AccountRoleService;

@RestController
@Transactional
public class AccountRolesController {
	@Autowired(required = false)
	private AccountRoleService roleservice;

	@RequestMapping(value = "/roles/add", method = RequestMethod.POST)
	public String addRoles(@RequestBody String json) {

		AccountRoles user = null;
		try {
			user = new ObjectMapper().readValue(json, AccountRoles.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		roleservice.add(user);

		return "success";
	}

	@RequestMapping(value = "/roles/delete", method = RequestMethod.GET)
	public String deleteRole(@RequestParam Long id) {
		roleservice.delete(id);
		return "deleted";
	}

	@RequestMapping(value = "/roles/get", method = RequestMethod.GET)
	public List<AccountRoles> get() {
		List<AccountRoles> list = roleservice.getAll();
		return list;
	}
	
	
	
	
}

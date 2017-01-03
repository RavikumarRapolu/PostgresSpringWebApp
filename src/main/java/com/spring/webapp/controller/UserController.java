package com.spring.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.webapp.bean.LoginBean;
import com.spring.webapp.entity.User;
import com.spring.webapp.service.UserService;

@RestController
@Transactional
@Component
public class UserController {
	@Autowired(required = false)
	private UserService userservice;

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@RequestBody String json) {

		User role = null;
		try {
			role = new ObjectMapper().readValue(json, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		userservice.add(role);

		return "success";
	}

	@RequestMapping(value = "/user/get", method = RequestMethod.GET)
	public List<User> getAll() {
		List<User> users = userservice.getAllUsers();
		return users;
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String update(@RequestBody String json) {
		User user = null;
		try {
			user = new ObjectMapper().readValue(json, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		userservice.update(user);
		return "updated";
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	public String delete(@RequestParam Long id) {
		userservice.delete(id);
		return "deleeted";
	}
	
	/*@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView  login(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("userModel") LoginBean user,BindingResult result) {
		//System.out.println("json "+json);
		//User user = new User();
//		try {
//			user = new ObjectMapper().readValue(json, User.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		User u = userservice.getUserByEmail(user.getEmail());
		if(u.getPassword().equals(user.getPassword())){
			request.setAttribute("loggedInUser", u.getName());
			return new ModelAndView("welcome", "userModel",u);
			}else{
			return new ModelAndView("index");
		}
		
	}*/
	
	 @RequestMapping(method = RequestMethod.POST)
	    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
	        if (loginBean != null && loginBean.getEmail() != null & loginBean.getPassword() != null) {
	            if (loginBean.getEmail().equals("ravi") && loginBean.getPassword().equals("ravi1")) {
	                model.addAttribute("msg", "welcome" + loginBean.getEmail());
	                return "welcome";
	            } else {
	                model.addAttribute("error", "Invalid Details");
	                return "index";
	            }
	        } else {
	            model.addAttribute("error", "Please enter Details");
	            return "index";
	        }
	    }
	

}

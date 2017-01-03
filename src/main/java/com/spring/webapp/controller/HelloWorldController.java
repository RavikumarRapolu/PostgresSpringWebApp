package com.spring.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {

	@RequestMapping(value = "/hai", method = RequestMethod.GET)
	@ResponseBody
	public String sayHai() {
		return "HelloWorld";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView Hello(@RequestParam(value = "name") String name) {
		return new ModelAndView("helloworld", "name", name);
	}
}

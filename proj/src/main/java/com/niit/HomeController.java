package com.niit;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.UserInfo;
import com.niit.services.DataServices;

@Controller
public class HomeController {
	@Autowired
	DataServices dataservices;

	@RequestMapping("/")
	public String getIndex() {
		System.out.println("home page");
		return "index";
	}

	@RequestMapping(value = "/sign")
	public String getSign() {
		System.out.println("in login page");
		return "sign";
	}

	@RequestMapping(value = "/register")
	public String getRegister(Map<String, Object> map) {
		UserInfo user = new UserInfo();
		map.put("user", user);
		System.out.println("In register page");
		return "register";
	}

	@RequestMapping("/RegisterIns")
	public String doRegister(@ModelAttribute UserInfo user, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		
	
		dataservices.insertRow(user);
return "register";
	}
	}
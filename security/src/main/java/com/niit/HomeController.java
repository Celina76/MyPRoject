package com.niit;



import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.UserInfo;
import com.niit.services.DataServices;

@Controller
public class HomeController {
	@Autowired
	DataServices dataservices;
	UserInfo user;

	@RequestMapping("/")
	public String getIndex() {
		System.out.println("home page");
		
		return "index";
	}

	
	
	//Spring Security see this :
		@RequestMapping(value = "/sign", method = RequestMethod.POST)
		public ModelAndView login(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout,@ModelAttribute UserInfo user, BindingResult result) {

			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("sign");

			return model;

		}
		//for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

		  ModelAndView model = new ModelAndView();

		  //check if user is login
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserInfo user = (UserInfo) auth.getPrincipal();
			model.addObject("username", user.getUsername());
		  }

		  model.setViewName("403");
		  return model;

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
		
package com.niit;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

	@RequestMapping(value={"/","/index"})
	public String getIndex() {
		System.out.println("home page");
		
		return "index";
	}

	@RequestMapping(value={"/login","/userLogin"}, method = RequestMethod.GET)
	public ModelAndView getlog( @RequestParam(required = false) String authfailed, String logout,String denied)     
	{
		String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
			return new ModelAndView("error","message", message);	
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
			new ModelAndView("index","message", message);	
		} else if (denied != null) {
			message = "Access denied for this user !";
			new ModelAndView("403","message", message);	
		}
		
		return new ModelAndView("sign","message", message);	 
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		 System.out.println("in login logout method");
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     if (auth != null){    
	         new SecurityContextLogoutHandler().logout(request, response, auth);
	     }
	     return "redirect: index?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	 }	 

	@RequestMapping("/403")
	public String ge403denied() {
		return "403";
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
		
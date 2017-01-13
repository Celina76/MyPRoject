package com.niit;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println(user.getEmail());

		dataservices.insertRow(user);

		System.out.println("row inserted");

		return "register";
	}

	@RequestMapping("/list")
	public String getList() {
		List userList = dataservices.getAllUserInfo();
		return "List";
	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam int userid) {
		dataservices.delete(userid);
		return "redirect:List";
	}

	@RequestMapping("/edit")
	public String editUser(@RequestParam int userid, @ModelAttribute UserInfo user) {
		dataservices.edit(user);
		return "redirect:List";
	}

	@RequestMapping("/getuser")
	public String getUser(@RequestParam int userid) {
		dataservices.getUser(userid);
		return "redirect:List";
	}
}

// @RequestMapping("/validate")
// public ModelAndView validate(@RequestParam("username") String username,
// @RequestParam("password") String password) {
// System.out.println("In validate method");
// System.out.println("username:" + username);
// System.out.println("password:" + password);
// ModelAndView mv = new ModelAndView("sign");
//
// UserDao userDAO = (UserDao) new UserDaoImpl();
// if (userDAO.isValidCredentials(username, password) == true)
// {
// mv.addObject("successMsg", "you logged in successfully");
//
// } else
// {
// mv.addObject("errorMsg", "Invalid Credentials");
// }
// return mv;
// }

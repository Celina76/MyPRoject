package com.niit.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.model.Shipping;
import com.niit.model.UserInfo;
import com.niit.music.dao.UserDao;
import com.niit.services.ShippingService;

@Component
public class Shippinghandler {
	@Autowired(required=true)
	ShippingService sss;
	@Autowired
	HttpServletRequest req;
	@Autowired
	UserDao u;

	public Shipping initFlow() {
		System.out.println("trigerring shipping flow");
		return new Shipping();
	}

	public String validateDetails(Shipping ship, MessageContext messageContext) {
		String status = "success";
		if (ship.getName().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("name").defaultText("Name cannot be Empty").build());
			status = "failure";
		}
		if (ship.getAddress().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("address").defaultText("Address cannot be Empty").build());
			status = "failure";
		}
		if (ship.getCity().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("city").defaultText("City cannot be Empty").build());
			status = "failure";
		}
		if (ship.getState().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("state").defaultText("State cannot be Empty").build());
			status = "failure";
		}
		if (ship.getPincode().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("pincode").defaultText("Pincode cannot be Empty").build());
			status = "failure";
		}

		return status;
	}

	// public String ship(Shipping ship){
	public String add(Shipping ship) {
//		System.out.println("It is entering into the shipping address");
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();
//
//		List<UserInfo> userDetail = u.getUserByName(username);
//		System.out.println("It is entering into the shipping address block");
//
//		for (int i = 0; i < userDetail.size(); i++) {
//			System.out.println("It is entering into block which is to add user id");
//			ship.setUser(userDetail.get(i));
//
//		}
//		System.out.println("added");
//		sss.add(ship);
//		return " ";
//
//	}
	 System.out.println("celina");
	 String username;
	 Authentication auth =
	 SecurityContextHolder.getContext().getAuthentication();
	 String name = auth.getName();
	 HttpSession ses=req.getSession();
	 ses.setAttribute("u", name);
	 username=(String)ses.getAttribute("u");
	 UserInfo user=new UserInfo();
	 user.setUsername(username);
	 ship.setUser(user);
	 int id=ship.getS_id();
	 sss.add(ship);
	 System.out.println("celina1");
	 return "success";
	 }

}

package com.niit.handler;

import org.springframework.binding.message.MessageBuilder;

import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.model.UserInfo;

@Component
public class Demohandler {

	public UserInfo initFlow() {
		System.out.println("triggering");
		return new UserInfo();
	}

	public String validateDetails(UserInfo user, MessageContext messageContext)

	{

		String status = "success";
		System.out.println("validating");
		if (user.getFirstname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("firstname").defaultText("firstname cannot be Empty").build());
			status = "failure";
		}
		if (user.getLastname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("lastname").defaultText("lastname cannot be Empty").build());
			status = "failure";
		}
		if (user.getUsername() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("username").defaultText("username cannot be Empty").build());
			status = "failure";
		}
		if (user.getEmail() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("email").defaultText("email cannot be Empty").build());
			status = "failure";
		}
		if (user.getPassword() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("password cannot be Empty").build());
			status = "failure";
		}
		if (user.getConfirmpwd() == null) {
			messageContext.addMessage(new MessageBuilder().error().source("confirmpwd")
					.defaultText("confirmpwd cannot be Empty").build());
			status = "failure";
		}
		return status;
	}

}

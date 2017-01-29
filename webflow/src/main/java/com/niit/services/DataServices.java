package com.niit.services;

import java.util.List;

import com.niit.model.UserInfo;

public interface DataServices {
	public void insertRow(UserInfo user);

	public List<UserInfo> getUser_id();

	public UserInfo getByUserName(String username, String password);

}

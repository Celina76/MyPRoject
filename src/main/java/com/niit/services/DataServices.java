package com.niit.services;

import java.util.List;

import com.niit.model.UserInfo;

public interface DataServices {
	public  void insertRow(UserInfo user) ;
	public void edit(UserInfo user);
	public void delete(int userid);
	public UserInfo getUser(int userid);
	public List getAllUserInfo();

		
	

}

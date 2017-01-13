package com.niit.music.dao;

import java.util.List;

import com.niit.model.UserInfo;

public interface CategoryDao {
	public void insertRow(UserInfo user);

	public void edit(UserInfo user);

	public void delete(int userid);

	public UserInfo getUser(int userid);

	public List getAllUserInfo();

	// public boolean isValidCredentials(String id,String password);
	

}

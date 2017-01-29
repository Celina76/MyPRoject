package com.niit.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserInfo;
import com.niit.music.dao.UserDao;
import com.niit.services.DataServices;

@Service

public class DataServicesImpl implements DataServices {
	@Autowired
	UserDao userDao;

	@Override
	@Transactional

	public void insertRow(UserInfo user) {

		userDao.insertRow(user);
		System.out.println("Service is added");
	}

	@Override
	public List<UserInfo> getUser_id() {
		// TODO Auto-generated method stub
		return userDao.getUser_id();
	}

	@Override
	public UserInfo getByUserName(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(username, password);
	}

}

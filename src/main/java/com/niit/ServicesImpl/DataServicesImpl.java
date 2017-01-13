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
	public void edit(UserInfo user) {
	userDao.edit(user);
		
	}

	@Override
	public void delete(int userid) {
		userDao.delete(userid);
		
	}

	@Override
	public UserInfo getUser(int userid) {
		
		return userDao.getUser(userid);
	}

	@Override
	public List getAllUserInfo() {
		
		return userDao.getAllUserInfo();
	}

}

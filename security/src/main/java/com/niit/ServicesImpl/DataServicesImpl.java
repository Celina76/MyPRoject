package com.niit.ServicesImpl;

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

	
}

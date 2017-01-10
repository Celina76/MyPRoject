package com.niit.music.dao.daoImpl;

import org.hibernate.Session;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserInfo;
import com.niit.music.dao.UserDao;
@EnableTransactionManagement
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	 SessionFactory sessionFactory;
	@Override
	@Transactional
	public void insertRow(UserInfo user) {
		
		  Session session = sessionFactory.openSession();
	 	  session.save(user);
		  
		 	 System.out.println("in Dao impl");
		
		}
			
	}

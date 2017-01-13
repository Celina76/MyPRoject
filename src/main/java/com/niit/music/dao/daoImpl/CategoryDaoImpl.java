package com.niit.music.dao.daoImpl;

import java.util.List;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserInfo;
import com.niit.music.dao.UserDao;
@Repository
public class CategoryDaoImpl implements UserDao {
	@Autowired
	 SessionFactory sessionFactory;
	@Override
	@Transactional
	public void insertRow(UserInfo user) {
		
		  Session session = sessionFactory.openSession();
	 	  session.save(user);
		  
		 	 System.out.println("in Dao impl");
		
		}
				@Override
				@Transactional
	public void edit(UserInfo user) {
				sessionFactory.getCurrentSession().update(user);
		
	}
	@Override
	@Transactional
	public void delete(int userid) {
		sessionFactory.getCurrentSession().delete(getUser(userid));
	}
	@Override
	@Transactional
	public UserInfo getUser(int userid) {
		Session session=sessionFactory.openSession();
		return (UserInfo)((SessionFactory) session).getCurrentSession().get(UserInfo.class,userid);
	}
	@Override
	@Transactional
	public List getAllUserInfo() {
		Session session=sessionFactory.openSession();
		return ((SessionFactory) session).getCurrentSession().createQuery("from categ").list();
}
	}
//	public boolean isValidCredentials(String id, String password) {
//		//need to test against db
//				//temp id:niit and password:niit@123
//				System.out.println("in backend");
//				if (id.equals("niit") &&password.equals("123"))
//				{
//					return true;
//					
//				}
//				else
//				{
//					return false;
//				}
//			}
	
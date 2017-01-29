package com.niit.music.dao.daoImpl;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserInfo;
import com.niit.model.UserRole;
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
		user.setEnabled(true);
		UserRole ur = new UserRole();
		ur.setUser_id(user);
		ur.setRole("ROLE_USER");

		session.save(user);
		session.save(ur);

		System.out.println("in Dao impl");

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserInfo> getUser_id() {

		return (List<UserInfo>) sessionFactory.getCurrentSession().createQuery("from UserInfo").list();

	}

	@Override
	@Transactional
	public UserInfo getByUserName(String username, String password) {
		return (UserInfo) sessionFactory.getCurrentSession()
				.createQuery("from USERINFO where username=? and password=? where username=?").list();
	}

}
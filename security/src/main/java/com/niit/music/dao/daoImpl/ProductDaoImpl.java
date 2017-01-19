package com.niit.music.dao.daoImpl;

import java.io.Serializable;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProductInfo;
import com.niit.music.dao.ProductDao;
@EnableTransactionManagement
@Repository
public class ProductDaoImpl implements ProductDao {
@Autowired
SessionFactory ss;
@Transactional
@Override
public int add(ProductInfo product) {
	
	
		  Session session = ss.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(product);
		  tx.commit();
		  Serializable id = session.getIdentifier(product);
		  session.close();
		return (Integer) id;  
	
}
@Transactional
@Override
public List getList() {
	Session session = ss.openSession();
	 List list = session.createQuery("from ProductInfo").list();
			    
			  session.close();
			  return list;
	

}
@Transactional
@Override
public ProductInfo getRowById(int id) {
	
	 Session session = ss.openSession();
	  ProductInfo prod = (ProductInfo) session.load(ProductInfo.class, id);
	  return prod;

	
}
@Transactional
@Override
public int updateRow(ProductInfo product) {
		Session session = ss.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(product);
	  tx.commit();
	  Serializable id = session.getIdentifier(product);
	  session.close();
	  return (Integer) id;
}
@Transactional
@Override
public int deleteRow(int id) {
	
	Session session = ss.openSession();
	  Transaction tx = session.beginTransaction();
	  ProductInfo product = (ProductInfo) session.load(ProductInfo.class, id);
	  session.delete(product);
	  tx.commit();
	  Serializable ids = session.getIdentifier(product);
	  session.close();
	  return (Integer) ids;
	 }
}


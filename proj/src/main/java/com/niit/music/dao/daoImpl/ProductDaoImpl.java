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
public int add(ProductInfo prod) {
	
	
		  Session session = ss.openSession();
		  Transaction tx = session.beginTransaction();
		  session.save(prod);
		  tx.commit();
		  Serializable id = session.getIdentifier(prod);
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
	//return ss.getCurrentSession().createQuery("from ProductInfo").list();

}
@Transactional
@Override
public ProductInfo getRowById(int product_id) {
	
	 Session session = ss.openSession();
	  ProductInfo prod = (ProductInfo) session.load(ProductInfo.class, product_id);
	  return prod;

	//return (ProductInfo)ss.getCurrentSession().get(ProductInfo.class, product_id);
}
@Transactional
@Override
public int updateRow(ProductInfo prod) {
	//ss.getCurrentSession().update(prod);
	Session session = ss.openSession();
	  Transaction tx = session.beginTransaction();
	  session.save(prod);
	  tx.commit();
	  Serializable id = session.getIdentifier(prod);
	  session.close();
	  return (Integer) id;
}
@Transactional
@Override
public int deleteRow(int product_id) {
	//ss.getCurrentSession().delete(getRowById(product_id));
	Session session = ss.openSession();
	  Transaction tx = session.beginTransaction();
	  ProductInfo prod = (ProductInfo) session.load(ProductInfo.class, product_id);
	  session.delete(prod);
	  tx.commit();
	  Serializable ids = session.getIdentifier(prod);
	  session.close();
	  return (Integer) ids;
	 }
}


package com.niit.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProductInfo;
import com.niit.music.dao.ProductDao;
import com.niit.services.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductDao pd;
	@Override

	public int add(ProductInfo product) {
		return pd.add(product);
		
	}

	@Override
	
	public List getList() {
		
		return pd.getList();
	}

	@Override

	public ProductInfo getRowById(int id) {
		
		return pd.getRowById(id);
	}

	@Override

	public int updateRow(ProductInfo product) {
	return	pd.updateRow(product);
		
	}

	@Override
	public int deleteRow(int id) {
		return pd.deleteRow(id);
		
	}

}

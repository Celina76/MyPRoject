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

	public int add(ProductInfo prod) {
		return pd.add(prod);
		
	}

	@Override
	
	public List getList() {
		
		return pd.getList();
	}

	@Override

	public ProductInfo getRowById(int product_id) {
		
		return pd.getRowById(product_id);
	}

	@Override

	public int updateRow(ProductInfo prod) {
	return	pd.updateRow(prod);
		
	}

	@Override
	public int deleteRow(int product_id) {
		return pd.deleteRow(product_id);
		
	}

}

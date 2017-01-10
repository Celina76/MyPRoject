package com.niit.music.dao;

import java.util.List;

import com.niit.model.ProductInfo;

public interface ProductDao {
public int add(ProductInfo prod);
public List getList();

public ProductInfo getRowById(int product_id);

public int updateRow(ProductInfo prod);

public int deleteRow(int product_id);


}

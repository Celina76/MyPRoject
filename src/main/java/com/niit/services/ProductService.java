package com.niit.services;

import java.util.List;

import com.niit.model.ProductInfo;

public interface ProductService {
	public int add(ProductInfo product);
	public List getList();

	public ProductInfo getRowById(int id);

	public int updateRow(ProductInfo product);

	public int deleteRow(int id);

}

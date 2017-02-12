package com.niit.music.dao;

import java.util.List;

import com.niit.model.Shipping;

public interface ShippingDao {
public void add(Shipping ship);
public void edit(Shipping ship);
public List getbyid(int user_id);
}

package com.niit.services;

import java.util.List;

import com.niit.model.CartItems;

public interface CartItemsService {
	public void add(CartItems cartitems);
	
	public void delete (int cartItems_id);
	public List<CartItems> getAllCartItems();
	public CartItems getCartItems(int cartItems_id);
	public void update(CartItems cartitems);
	public int cartLength();
	public List<CartItems> getbyuserid(int user_id);
}





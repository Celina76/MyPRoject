package com.niit.music.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItems;

public interface CartItemsDao {
	public void add(CartItems cartitems);
	
	public void delete (int cartItems_id);
	public List<CartItems> getAllCartItems();
	public CartItems getCartItems(int cartItems_id);
	void update(CartItems cartitems);
	public int cartLength();
	public List getbyid(int user_id);
}






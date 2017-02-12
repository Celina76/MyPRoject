package com.niit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Cart;
import com.niit.model.CartItems;
import com.niit.model.UserInfo;
import com.niit.music.dao.ShippingDao;
import com.niit.music.dao.UserDao;
import com.niit.services.CartItemsService;
import com.niit.services.CartService;

@Controller
public class PaymentController {
	@Autowired
	private CartService ps;
	@Autowired
	private CartItemsService cs;
	@Autowired
	private UserDao ud;
	@Autowired
	private ShippingDao bad;
	@Autowired
	private ProductController pc;

	@RequestMapping("/thanks")
	public String pay(HttpServletRequest req){
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 String username = auth.getName(); 
	 System.out.println(username);
	 List<UserInfo> userDetail = ud.getUser(username);
	 @SuppressWarnings("unchecked")
	List<CartItems> list=cs.getAllCartItems();
	 List<CartItems> crt = cs.getbyuserid(userDetail.get(0).getUser_id());
	 Cart cart=new Cart();
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    Date date = new Date();
    DateFormat dateFormats = new SimpleDateFormat("hh:mm:ss a");
    Calendar cal = Calendar.getInstance();
    pc.update(crt);
	 for (int i=0;i<list.size();i++)
	 {
	     String Date=dateFormat.format(date);
        String Time=dateFormats.format(cal.getTime());
		 cart.setDate_time(Date);
		 cart.setDate_time(Time);
        cart.setProduct_fk(list.get(i).getId_fk());
		 cart.setQuantity(list.get(i).getQuantity());
		 cart.setTotal(list.get(i).getTotalPrice());
		 String name1= auth.getName();
		 ps.add(cart); 
	
	
	
	
//	public String pay(HttpServletRequest req) { // BY USENAME WE ARE CALLING THE
//												// USERID
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();
//
//		List<UserInfo> userDetail = ud.getUser(username);// user details are
//															// stored in
//															// userDetail object
//
//		System.out.println(userDetail.get(0).getUser_id()); // using the
//															// userDetail
//															// object,we are
//															// calling the
//															// userid by
//															// getUserid()
//System.out.println("payment");
//		Cart cart = new Cart();
//		System.out.println("cart entity class");
//		// to store the userid in cart in cart table
//		cart.setRegister_fk(userDetail.get(0));// setId_fk is the foreign key
//												// of userid
//		// ................................................................................................................................................................
//
//		// to store the quantity,productid,grandtotal in Cart table
//
//		/* List<Cartitems> crt=cs.getAllCartitems(); */
//		List<CartItems> crt = cs.getbyuserid(userDetail.get(0).getUser_id());
//		
//		int tot = 0;
//System.out.println("list");
//		for (int i = 0; i < crt.size(); i++)
//		{
//			System.out.println("kjhgfd");
//			cart.setProduct_fk(crt.get(i).getId_fk());
//			cart.setQuantity(crt.get(i).getQuantity());
//			tot = (int) (tot + (crt.get(i).getTotalPrice()));
//		}
//
//		cart.setTotal(tot);
//		ps.add(cart);

		// .....................................................................................................

		// to store cartid in User table
		userDetail.get(0).setUser_id(userDetail.get(0).getUser_id());

		userDetail.get(0).setCart(cart);// setCart is the foreign key setter
											// method

		ud.edit(userDetail.get(0));
		// ...........................................................................................................

		// delete caritem table, after add to the Cart table
		for (int a = 0; crt.size() > a; a++) {
			cs.delete(crt.get(a).getCartItems_id());
		}

		// ...................................................................................................

		// to store the cartid,shipid,userid in Orders table

		/*
		 * List<BillingAddress>
		 * bd=bad.getbyid(userDetail.get(0).getUserid());//by using
		 * userid(billingaddress) //we are storing the shipid in order table
		 * 
		 * Orders orders = new Orders(); orders.setCart(carts);
		 * orders.setShipment(bd.get(0)); orders.setRegdet(userDetail.get(0));
		 * ps.orderadd(orders);
		 */}
		return "index";
	}
}

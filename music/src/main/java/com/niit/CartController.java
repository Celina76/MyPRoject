package com.niit;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.CartItems;
import com.niit.model.ProductInfo;
import com.niit.model.UserInfo;
import com.niit.music.dao.UserDao;
import com.niit.services.CartItemsService;
import com.niit.services.CartService;
import com.niit.services.CategoryService;
import com.niit.services.ProductService;

@Controller
public class CartController {
	@Autowired
	ProductService ps;
	@Autowired
	CartItemsService cartItemsService;
	@Autowired
	CategoryService cs;
	@Autowired
	UserDao us;
	@Autowired
	CartService crt;
	@RequestMapping("/addtocart")
	
	public String AddtoCart(@RequestParam("cart") int id, Map<String, Object> map, ProductInfo product,HttpSession session) 
	{
		
		CartItems cart = new CartItems();
		ProductInfo p1 = ps.getRowById(id);	
		
		List<CartItems> crt=cartItemsService.getAllCartItems();
		/* search the table whether the product is new or existing*/
		for(int i=0;i<crt.size();i++)
		{	
			//get product id from the cartitem table
			System.out.println("quantity");
			int tempid=crt.get(i).getId_fk().getId();
			//for update the existing product
			if(tempid==id)
			{	
				int quantity=crt.get(i).getQuantity()+1;//if same product added,it wil increase the quantity
				crt.get(i).setQuantity(quantity);
				int price=p1.getPrice()*quantity;//this wil multiply prod price * qty
				crt.get(i).setTotalPrice(price);
				cartItemsService.update(crt.get(i));
				map.put("cartList", cartItemsService.getAllCartItems());
				
				return "cart";
			}
		}
		

		cart.setQuantity(1);//setter method of quantity in cartitems table
		cart.setTotalPrice(p1.getPrice());
		cart.setId_fk(p1);//foreign key of Productid
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
System.out.println(username);
		List<UserInfo> userDetail = us.getUser(username);
		//System.out.println("It is entering into the shipping address block");

		for (int i = 0; i < userDetail.size(); i++) {
			//System.out.println("It is entering into block which is to add user id");
			cart.setUser_fk(userDetail.get(i));}
		cartItemsService.add(cart);//add the quantity,total,productid in cartitems table using the cart object
		map.put("product", p1);
		map.put("cartList", cartItemsService.getAllCartItems());
		session.setAttribute("cartlength", cartItemsService.cartLength());
		
		map.put("categoryList", cs.getAllCategory());
		map.put("productList", ps.getList());
		
		return "cart";

	}
	@RequestMapping("/remove")
	public String rem(@RequestParam("pdt3") int id, Map<String, Object> map,HttpSession session) {
		cartItemsService.delete(id);
		map.put("cartList", cartItemsService.getAllCartItems());
		session.setAttribute("cartlength", cartItemsService.cartLength());
		return "cart";
	}

	@RequestMapping("delete/cart/{cartItems_id}")
	public String delcart(@PathVariable("cartItems_id")int id,ModelMap model,HttpSession session)
	{	
		
		cartItemsService.delete(id);
		session.setAttribute("cartlength", cartItemsService.cartLength());
		return"redirect:/cart";
	}
	
	//method to get all the product from the table
	@RequestMapping("/cart")
	public String getcart(Model map )
	{
		CartItems cart=new CartItems();
		//List<CartItems> crt=cartService.getAllProduct();
		map.addAttribute("cart", cart);
		map.addAttribute("cartList", cartItemsService.getAllCartItems());
		return "cart";
	}
}

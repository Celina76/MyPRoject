package com.niit;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.ProductInfo;
import com.niit.model.UserInfo;
import com.niit.services.ProductService;

@Controller
public class ProductController {
@Autowired
ProductService ps;
ProductInfo prodObj=null;
@RequestMapping("/product")
public ModelAndView getProduct(@ModelAttribute ProductInfo prod) {
	return new  ModelAndView("Product");

}
@RequestMapping("/productadd")
public ModelAndView addProduct(@ModelAttribute ProductInfo prod) {
		ps.add(prod);
return new ModelAndView("redirect:list");
}
@RequestMapping(value="/list")
public ModelAndView getList() {
	
	List  list=ps.getList();
System.out.println("getting list");
return new ModelAndView("List","list",list);
}

@RequestMapping("/delete")
public ModelAndView deleteProduct(@RequestParam int product_id) {
 ps.deleteRow(product_id);
 return new ModelAndView("redirect:list");
}

@RequestMapping("/edit")
public ModelAndView editProduct(@RequestParam int product_id, @ModelAttribute ProductInfo prod ) {
  prodObj = ps.getRowById(product_id);
 return new ModelAndView("edit", "prodObj", prodObj);
}

@RequestMapping("/update")
public ModelAndView updateProduct(@ModelAttribute ProductInfo prod) {
	int id=prodObj.getProduct_id();
	System.out.println(id);
	prod.setProduct_id(id);
 ps.updateRow(prod);
 return new ModelAndView("redirect:list");
}




}

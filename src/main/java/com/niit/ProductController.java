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
	ProductService pservice;
	ProductInfo productObject=null;
	@RequestMapping("/product")
	public  ModelAndView  getProductPage(@ModelAttribute ProductInfo product, BindingResult result) {
System.out.println("view product adding page");
		return new  ModelAndView("Product");
	}
	

	@RequestMapping("/productadd")
	public  ModelAndView getProduct(@ModelAttribute ProductInfo product, BindingResult result) {
     pservice.add(product);
     
     System.out.println("product is added");
		return new ModelAndView("redirect:list");
	}
	@RequestMapping("/list")
	 public ModelAndView getList() {
	  List list = pservice.getList();
	  System.out.println("product list");
	  return new ModelAndView("List", "list", list);
	 }


	 @RequestMapping("/delete")
	 public ModelAndView deleteProduct(@RequestParam int id) {
	  pservice.deleteRow(id);
	  System.out.println("delete product");
	  return new ModelAndView("redirect:list");
	 }
 @RequestMapping("/edit")
	 public ModelAndView editProduct(@RequestParam int id,
	   @ModelAttribute ProductInfo product, BindingResult result,Map<String, Object> map) {
	   productObject = pservice.getRowById(id);
	   map.put("ProductInfo",product);
	   System.out.println("edit product");
	  return new ModelAndView("edit", "productObject", productObject);
	 }
	 @RequestMapping("/update")
	 public ModelAndView updateProduct(@ModelAttribute ProductInfo product, BindingResult result) {
		 int id = productObject.getId();
		 System.out.println(id);
		 product.setId(id);
		 pservice.updateRow(product);
		 System.out.println("update product");
	  return new ModelAndView("redirect:list");
	 }





}

package com.niit;

import java.io.BufferedOutputStream;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.ProductInfo;
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
	public  String getProduct(@ModelAttribute ProductInfo product, BindingResult result) {
     pservice.add(product);
     
         if (!product.getImage().isEmpty()) {
			try {
				byte[] bytes = product.getImage().getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "resources/image");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + product.getProduct_name()+".jpg");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + product.getProduct_name();
			} catch (Exception e) {
				return "You failed to upload " + product.getProduct_name() + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + product.getProduct_name()
					+ " because the file was empty.";
		}
	
				
        
		
				
//		return "redirect:list";
	}
	@RequestMapping("/display")
	public ModelAndView viewImg(@ModelAttribute ProductInfo product,Map<String, Object> map)
	{
		ModelAndView mv=new ModelAndView("display");
	map.put("List",pservice.getList());
	System.out.println("getting details from list");
		map.put("image",product.getProduct_name());
		System.out.println("getting image using name of the product");
		return mv;
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

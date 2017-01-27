package com.niit;

import java.io.BufferedOutputStream;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
	ServletContext servletContext;
	@RequestMapping("/product")
	public  ModelAndView  getProductPage(@ModelAttribute ProductInfo product, BindingResult result) {
System.out.println("view product adding page");
		return new  ModelAndView("Product");
	}
	

	@RequestMapping("/productadd")
	public  ModelAndView getProduct(@ModelAttribute ProductInfo product, BindingResult result,HttpServletRequest hm) {
    
     servletContext =hm.getServletContext();
         if (!product.getImage().isEmpty())
         {System.out.println("get image");
			try {
				 System.out.println("get image "+servletContext);
				byte[] bytes = product.getImage().getBytes();
				System.out.println("get image "+servletContext.getRealPath("/"));
				// Creating the directory to store file
				String rootPath = servletContext.getRealPath("/");
//				String rootPath = System.getProperty("catalina.home");
				System.out.println("get image "+rootPath);
				File dir = new File(rootPath + File.separator + "resources/images");
				if (!dir.exists())
					{dir.mkdirs();
			 }else{
	    		 System.out.println("filee "+dir.exists());
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator +product.getProduct_name()+".jpg");
				System.out.println(serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("server file location"+serverFile.getAbsolutePath());
				 pservice.add(product);
	    	 }
				return new ModelAndView("redirect:list");
				} catch (Exception e) {
					e.printStackTrace();
					return new ModelAndView("redirect:list");
				}
			} else {
				return new ModelAndView("redirect:list");
			}
		
		}

//				// Create the file on server
//				File serverFile = new File(dir.getAbsolutePath()
//						+ File.separator + product.getProduct_name()+".jpg");
//				BufferedOutputStream stream = new BufferedOutputStream(
//						new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//
//				System.out.println("Server File Location="
//						+ serverFile.getAbsolutePath());
//
//				return "You successfully uploaded file=" + product.getProduct_name();
//			} catch (Exception e) {
//				return "You failed to upload " + product.getProduct_name() + " => " + e.getMessage();
//			}
//		} else {
//			return "You failed to upload " + product.getProduct_name()
//					+ " because the file was empty.";
//		}
	
				
        
		
				
//		return "redirect:list";
	
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

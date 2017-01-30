package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity //for crating table in database
@Table(name = "product")//mention name for the table
public class ProductInfo implements Serializable //creating the class for product details implementing serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductInfo() {}//constructor is created for pojo class

	@Id //it indicate the primary key for the table
	@Column 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//generation type for id can be auto or identity
	private int id;
	@Column
	
	
	private String product_name;
	@Column
	
	private String description;
	@Column
	
	private String supplier_name;
	@Column
	
	private String category_name;
	@Column
	
	@Transient
	private MultipartFile image;
//getter and setter methods for all the fields 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}

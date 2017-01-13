package com.niit.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "categ")

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public UserInfo(){}



@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int userid;
@Column
private String username;


private String email;
@Column
private String password;
//@Column
//private String country;
//@Column
//private String gender;

public String getUsername() {
	System.out.println("getting username");
	return username;
}
public void setUsername(String username) {
	this.username = username;
	System.out.println("setting username");

}
public String getEmail() {
	System.out.println("getting email");

	return email;
}
public void setEmail(String email) {
	this.email = email;
	System.out.println("seetting email");

}
public String getPassword() {
	System.out.println("getting password");

	return password;
}
public void setPassword(String password) {
	
	this.password = password;
	System.out.println("setting password");

}
//public String getCountry() {
//	System.out.println("getting country name");
//
//	return country;
//}
//public void setCountry(String country) {
//	this.country = country;
//	System.out.println("setting country name");
//
//}
//public String getGender() {
//	System.out.println("getting gender");
//
//	return gender;
//}
//public void setGender(String gender) {
//	this.gender = gender;
//	System.out.println("setting gender");
//
//}

public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}

}
	
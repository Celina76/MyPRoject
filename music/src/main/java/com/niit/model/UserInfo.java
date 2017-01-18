package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class UserInfo   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public UserInfo(){}
@Column
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int User_id;
@Column
private String firstname;
@Column
private String lastname;
@Column
private String username;
@Column
private String email;
@Column
private String password;
@Column
private String confirmpwd;
public int getUser_id() {
	return User_id;
}
public void setUser_id(int user_id) {
	User_id = user_id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmpwd() {
	return confirmpwd;
}
public void setConfirmpwd(String confirmpwd) {
	this.confirmpwd = confirmpwd;
}

}

package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userrole")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserRole() {
	}

//	@OneToOne(cascade= "User_id", fetch = FetchType.EAGER)
	//private UserInfo user;
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	
	@OneToOne
	@JoinColumn(name = "User_id")
	private UserInfo User_id;
	@Column
	private String role;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public UserInfo getUser_id() {
		return User_id;
	}

	public void setUser_id(UserInfo user_id) {
		User_id = user_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

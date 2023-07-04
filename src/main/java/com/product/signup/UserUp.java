package com.product.signup;

import java.sql.Date;

public class UserUp {
	long id;
	String name;
	String email;
	String gender;
	Date dob;
	String username;
	String password;
	public UserUp(long id, String name, String email, String gender, Date dob, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.username = username;
		this.password = password;
	}
	public UserUp() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

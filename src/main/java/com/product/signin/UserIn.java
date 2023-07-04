package com.product.signin;

public class UserIn {

	String username;
	String password;
	public UserIn(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserIn() {
		super();
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

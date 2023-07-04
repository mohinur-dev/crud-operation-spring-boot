package com.product.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserUpDA {
	Connection con;
	PreparedStatement pst;
	
	//insert sign up user
	public void signup(UserUp sUp) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_db", "root", "nh123456");
			pst = con.prepareStatement("INSERT INTO user(id, name, email, gender, dob, username, password) VALUES(?, ?, ?, ?, ?, ?, ?)");
			pst.setLong(1, sUp.id);
			pst.setString(2, sUp.name);
			pst.setString(3, sUp.email);
			pst.setString(4, sUp.gender);
			pst.setDate(5, sUp.dob);
			pst.setString(6, sUp.username);
			pst.setString(7, sUp.password);
			pst.executeUpdate();				
		} catch (Exception e) {
			System.out.println("Cann't sign up" + e);
		}
	}

}

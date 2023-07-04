package com.product.signin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInDA {
	Connection con;
	PreparedStatement pst;
	
	public UserIn signIn(UserIn uIn) {
		UserIn uin = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_db", "root", "nh123456");
			pst = con.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
			pst.setString(1, uIn.username);
			pst.setString(2, uIn.password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				uin = new UserIn();
				uin.setUsername(rs.getString(1));
				uin.setPassword(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return uin;
	}
}

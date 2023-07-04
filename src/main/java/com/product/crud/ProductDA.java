package com.product.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDA {

	Connection con; 
	PreparedStatement pst;

	
	//show product method
	public List<Product> pList;
	public List<Product> show() {
		pList = new ArrayList<>();
		Product pdt;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_db", "root", "nh123456");
			pst = con.prepareStatement("SELECT * FROM products");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				pdt = new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));
				pList.add(pdt);
			}
		} catch (Exception e) {
			System.out.println("Cann.t get product" + e);
		}
		return pList;
	}
	
	
	//get product info by product id
	public Product productById(int id) {
		Product pdt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_db", "root", "nh123456");
			pst = con.prepareStatement("SELECT * FROM products WHERE id=" + id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				pdt = new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
		} catch (Exception e) {
			System.out.println("Cann.t get product by id" + e);
		}
		return pdt;
	}
	
	
	//insert product method
	public void insert(Product pdt) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_db", "root", "nh123456");
			pst = con.prepareStatement("INSERT INTO products(id, name, brand, price, stock, catagory, details, picture) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setLong(1, pdt.id);
			pst.setString(2, pdt.name);
			pst.setString(3, pdt.brand);
			pst.setDouble(4, pdt.price);
			pst.setInt(5, pdt.stock);
			pst.setString(6, pdt.catagory);
			pst.setString(7, pdt.details);
			pst.setString(8, pdt.picture);
			pst.executeUpdate();				
		} catch (Exception e) {
			System.out.println("Cann't insert product" + e);
		}
	}
	
	
	//update product method
	 public void update(Product pdt){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_db", "root", "nh123456"));
            pst = con.prepareStatement("UPDATE products SET name = ?, brand = ?, price = ?, stock = ?, catagory = ?, details = ?, picture = ? WHERE id = ?");
			pst.setString(1, pdt.name);
			pst.setString(2, pdt.brand);
			pst.setDouble(3, pdt.price);
			pst.setInt(4, pdt.stock);
			pst.setString(5, pdt.catagory);
			pst.setString(6, pdt.details);
			pst.setString(7, pdt.picture);
			pst.setLong(8, pdt.id);
             pst.executeUpdate();
        } catch (Exception e) {
        	System.out.println("Cann't update product" + e);
        }
    }
	 
	    
	 //delete product method
	 public void delete(Product pdt){
	     try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = (DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_db", "root", "nh123456"));
	         PreparedStatement pst = con.prepareStatement("DELETE FROM products WHERE id = ?");
	         pst.setLong(1, pdt.id);
	         pst.executeUpdate();
	     } catch (Exception e) {
	    	 System.out.println("Cann't delete product" + e);
	     }  
     }
	
}

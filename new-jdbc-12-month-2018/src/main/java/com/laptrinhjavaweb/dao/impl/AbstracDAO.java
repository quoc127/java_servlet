package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.laptrinhjavaweb.dao.GenericDAO;

public class AbstracDAO implements GenericDAO{
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			String url = "jdbc:mysql://localhost:8000/newservlet12month2018";
			String user= "root";
			String password = "quocngu198";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}		
	}
	
}

package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con = null;

	private DBConnection() {
	}
	static{
		try {
			Class.forName(DBInfo.driver);
			con=DriverManager.getConnection(DBInfo.url,DBInfo.username,DBInfo.password);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}
}
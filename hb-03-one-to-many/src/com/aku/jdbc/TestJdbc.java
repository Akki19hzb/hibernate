package com.aku.jdbc;

import java.sql.DriverManager;

import java.sql.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to Database"+jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successful");
			
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

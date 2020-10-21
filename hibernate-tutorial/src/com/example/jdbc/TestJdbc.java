package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String []args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Creating connection to database"+jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successful");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

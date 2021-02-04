package com.roberto.test.jdbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TestJdbcConnection {

	private static final String HOST_NAME = "localhost";
	private static final int PORT = 3306;	
	private static final String USERNAME_DB_USER = "hbstudent";
	private static final String PASSWORD_DB_USER = "hbstudent";
	private static final String DATABASE_NAME = "hb-01-one-to-one-uni";
	private static final String JDBC_URL = "jdbc:mysql://" + HOST_NAME +":" + PORT + "/" + DATABASE_NAME + "?useSSL=false&serverTimezone=UTC";
	
	public static void main(String[] args) {

		try {
			// verify if Driver class exists in classPath
			Class<?> JdbcDriverClass = Class.forName("com.mysql.cj.jdbc.Driver");
			 
			// try to connect database
			Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME_DB_USER, PASSWORD_DB_USER);
			System.out.println("Connection to database established...");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found in build path. Check if added Driver Jdbc in classpath...");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("Connection to database failed. Check database URL and retry...");
			e.printStackTrace();
		}
		
	}

}

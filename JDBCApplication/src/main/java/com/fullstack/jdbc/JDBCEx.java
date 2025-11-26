package com.fullstack.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx {
	
	//steps for jdbc
	
	/*
	 * 1.Load Driver Class 
	 * 2.Establish Database Connection 
	 * 3.Create Statement
	 * 4.Execute Query 
	 * 5.close DB Connection
	 */
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		
		// Load Driver Class
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Database Connection
			try {
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "tiger");
				
				//create statement
				
			Statement statement = connection.createStatement();
			
			//execute Query
			
			ResultSet resultSet = statement.executeQuery("select * from employee2");
			
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getDouble(3));
			}
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		finally {
			connection.close();
		}
		
		
	}

}

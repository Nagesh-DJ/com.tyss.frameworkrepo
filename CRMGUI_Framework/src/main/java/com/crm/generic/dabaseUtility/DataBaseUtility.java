package com.crm.generic.dabaseUtility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
//when we know url,un,psw 	
	public void getDBConnection() throws SQLException
	{
		
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		}
		catch (Exception e) {
		}	
	}
	
	
	//when we don't know url ,un,password
	public void getDBConnection(String url,String username,String password) throws SQLException
	{
		
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) {
		}	
	}
	
	
	public void closeDBConnection() throws SQLException {
		try
		{
		con.close();
		}catch (Exception e) {
		}
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException 
	{
		ResultSet result =null;
		try
		{
		Statement stmt = con.createStatement();
		 result = stmt.executeQuery(query);
		}
		catch (Exception e) {
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try
		{
			Statement stmt=con.createStatement();
			result=stmt.executeUpdate(query);
		}
		catch (Exception e) {
		}
		return result;
	}
	
}

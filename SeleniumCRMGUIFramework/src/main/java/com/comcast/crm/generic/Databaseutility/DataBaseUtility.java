package com.comcast.crm.generic.Databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	public void getDataBaseConnection(String url,String username,String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 con = DriverManager.getConnection(url, username, password);
	      }
		catch (Exception e) {
		
	      }
		}
	public void getDataBaseConnection() throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectDemo","root","Anand@123");
	      }
		catch (Exception e) {
		
	      }
		}
	public void closeDataBaseConnection() throws SQLException {
		try {
		con.close();
		}
		catch (Exception e) {
			
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);
		}
		catch (Exception e) {
			
		}
		return result; 
		
	}
	public int executeNonselectquery(String query) {
		int result=0;
		try {
			Statement stat=con.createStatement();
			stat.executeUpdate(query);
		}catch (Exception e) {
			
		}
		return result;
	}
	
}

package com.practise.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
@Test
	public void main(String[] args) throws SQLException {
		
		//register the driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection of database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		
		//Create statement
		Statement state = con.createStatement();
		String query = "Select * from Student_info;";
		
		//Execute query
		ResultSet result = state.executeQuery(query);
		while (result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
		
		//Close database
		con.close();
	}

}

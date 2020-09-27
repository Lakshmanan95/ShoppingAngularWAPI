package com.example.eshopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Password@95");
			return connection;
	}
public static void main(String[] args)
{
			try{
	        getConnection();
    }
    catch (SQLException | ClassNotFoundException e)
    {
	        e.printStackTrace();
    }
}

}

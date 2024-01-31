package com.web.bankdaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection conn;

	public static Connection getConnection() {
		if (conn == null) 
		{
			String url = "jdbc:mysql://localhost:3306/sushant";
			String user_name = "root";
			String password = "root";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user_name, password);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
		 PrintWriter out=resp.getWriter();
		 String email=req.getParameter("email");
		 String password=req.getParameter("password");
			try {
				
				Connection con=ConnectionProvider.getConnection();
				String query="select * from register";
				 PreparedStatement statement = con.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				while(rs.next()) 
				{
					String email1=rs.getString("email");
					String code=rs.getString("password");
					if(email1.equals(email)&&code.equals(password)) 
					{
						out.println("<h2>welcome to login page</h2>");
					}
				}
					
				
			} catch (SQLException e) {
				e.printStackTrace();	
			}
	
	}

}

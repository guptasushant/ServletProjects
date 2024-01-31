package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/updatePassword")
public class NewPassword extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	String newP = req.getParameter("newPassword");
	String cnfP = req.getParameter("confirmPassword");
	if(newP.equals(cnfP)) {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			HttpSession session = req.getSession();
			String email = (String) session.getAttribute("email");
			
			Connection con = ConnectionProvider.getConnection();
			String query= "UPDATE register SET password = ? WHERE email =? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, newP);
			ps.setString(2, email);
			int update = ps.executeUpdate();
			if(update>0) 
			{
				out.println("updated");
			}else 
			{
				out.println("not updated");
			}
        
        
        
			
        } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	}
}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
	            Thread.sleep(3000);
	           Connection con=ConnectionProvider.getConnection();
	            String query = "insert into register(firstName,lastName,email,password) values(?,?,?,?)";
	            PreparedStatement statement = con.prepareStatement(query);
	            statement.setString(1, firstname);
	            statement.setString(2, lastname);
	            statement.setString(3, email);
	            statement.setString(4, password);
	            statement.executeUpdate();
	
	            if (statement != null) 
	            {
	            	RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
	                dispatcher.include(req, resp);
	                out.println("<h1> Registration Done! Check your email for confirmation.</h1>");
	                EmailSender.sendEmail(req,resp);
	            }

        } 
        catch (SQLException | InterruptedException e) 
        {
            e.printStackTrace();
            out.println("Error");
        }
    }
}

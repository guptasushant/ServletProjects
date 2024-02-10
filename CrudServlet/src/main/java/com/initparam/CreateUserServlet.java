package com.initparam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet(urlPatterns = "/addservlet",initParams = {
//		@WebInitParam(name = "dburl",value = "jdbc:mysql://localhost/sushant"),
//		@WebInitParam(name = "dbuser",value = "root"),
//		@WebInitParam(name = "dbpassword",value = "root")
//		                                              }
//           )
public class CreateUserServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PrintWriter out;
	@Override
	public void init(ServletConfig config) throws ServletException {
	try {
		ServletContext context = config.getServletContext();
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(context.getInitParameter("dburl"),context.getInitParameter("dbuser"),context.getInitParameter("dbpassword"));
		System.out.println(conn);
	
	
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	out= resp.getWriter();
	resp.setContentType("text/html");
	
	}
}

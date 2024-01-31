package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name=req.getParameter("username");
		String code=req.getParameter("password");
		HttpSession session=req.getSession();
		session.setAttribute("username",name );
		session.setAttribute("password",code );
	
	
	
	if(name!=null) {
		RequestDispatcher dispatcher=req.getRequestDispatcher("index2.html");
		dispatcher.forward(req, resp);
		
	}
	else {
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.include(req, resp);
		out.println("<h2>Name is null</h2>");
	}
	}

}

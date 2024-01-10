package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("Username").trim();
		String password = req.getParameter("Password").trim();
		String email = req.getParameter("Email").trim();
		String gender = req.getParameter("Gender");
		String course = req.getParameter("course");
		String cond = req.getParameter("condition");
		if (cond != null) {
			out.println("<h2> Name :" + name + "</h2>");
			out.println("<h2> password :" + password + "</h2>");
			out.println("<h2> Email :" + email + "</h2>");
			out.println("<h2> Gender :" + gender + "</h2>");
			out.println("<h2>Course :" + course + "</h2>");
		} 
		else 
			{
				out.println("<h2>you have not accepted Terms & conditions</h2>");
			}

	}

}

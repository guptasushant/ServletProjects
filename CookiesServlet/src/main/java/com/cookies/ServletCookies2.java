package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class ServletCookies2 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	boolean f=false;
	String name="";
	Cookie[] cookies = req.getCookies();
	if(cookies==null) 
	{
		out.println("<h2>you are new user go to submit page</h2>");
		return;
	}else 
	{
		for (Cookie cookie : cookies) 
		{
			String tname=cookie.getName();
			if(tname.equals("username")) 
			{
				f=true;
				name=cookie.getValue();
			}
		}
	}
	if(f) 
	{
		out.println("<h2>Hello! "+name+" Welcome back to the website</h2>");
		out.println("<br>");
		out.println("<br>");
		out.println("<h2>Thank you!</h2>");
	}
	else 
	{
		out.println("<h2>you are new user go to home page</h2>");
	}
	}
}

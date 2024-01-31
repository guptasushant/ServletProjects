package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet1")
public class ServletCookies1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	resp.setContentType("text/html");
	String name=req.getParameter("username");
	out.println("<h2>welcome to servlet1 "+name+"</h2>");
	out.println("<a href=servlet2>Go to servlet 2</a>");
	Cookie c=new Cookie("username", name);
	resp.addCookie(c);
	}
}

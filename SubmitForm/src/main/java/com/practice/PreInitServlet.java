package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/",loadOnStartup = 2)
public class PreInitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

@Override
public void init() throws ServletException {
	System.out.println("in overrided init method");

}
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//	PrintWriter out = resp.getWriter();
//	resp.setContentType("text/html");
//	out.println("second Servlet");
//	RequestDispatcher rd =req.getRequestDispatcher("MyFile.jsp");
//	rd.forward(req, resp);
// }
	
}


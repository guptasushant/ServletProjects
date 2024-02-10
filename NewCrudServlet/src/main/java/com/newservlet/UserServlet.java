package com.newservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newservlet.bean.User;
import com.newservlet.dao.UserDao;
import com.newservlet.dao.UserDaoImpl;

@WebServlet("/registerUser")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		User user = new User();
		UserDao userDaoImpl = new UserDaoImpl();
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPhone_no(req.getParameter("phone_no"));
		user.setPassword(req.getParameter("password"));
		userDaoImpl.Register(user);
		if (userDaoImpl != null) {
			out.println("<h1>done successfully</h1>");
			resp.sendRedirect("display.jsp");

		}

	}
}

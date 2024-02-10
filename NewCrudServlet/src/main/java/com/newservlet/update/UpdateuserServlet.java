package com.newservlet.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newservlet.bean.User;
import com.newservlet.dao.UserDaoImpl;

@WebServlet("/UpdateUser")
public class UpdateuserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		User user = new User();
		UserDaoImpl impl = new UserDaoImpl();

		int id = Integer.parseInt(req.getParameter("userId"));
		user.setId(id);
		user.setEmail(req.getParameter("updateemail"));
		user.setPhone_no(req.getParameter("updatephone_no"));
		user.setPassword(req.getParameter("updatepassword"));
		impl.update(user);
		resp.sendRedirect("display.jsp");
		out.println("updated successfully");
	}
}

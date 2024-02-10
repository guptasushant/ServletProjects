package com.newservlet.delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newservlet.bean.User;
import com.newservlet.dao.UserDaoImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		User user = new User();
		UserDaoImpl impl = new UserDaoImpl();
		int id = Integer.parseInt(req.getParameter("userId"));
		user.setId(id);
		impl.delete(user);
		out.println("<h1>Deleted successfully</h1>");
	}
}

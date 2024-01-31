package com.web.bankcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bank.Bank;
import com.web.bankdao.BankDao;
import com.web.bankdaoimpl.BankDaoImpl;

@WebServlet("/updateServlet")
public class UpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	BankDao bankdao;
	PrintWriter pw;
	Bank bank;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		pw = resp.getWriter();
		bankdao = new BankDaoImpl();
		bank = new Bank();
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		// Bank update=bankdao.Update(id);
		// System.out.println(req.getParameter("firstName"));
		bank.setFirstname(req.getParameter("firstName"));
		bank.setLastname(req.getParameter("lastName"));
		bank.setAmount(req.getParameter("amount"));
		System.out.println(bank);
		bankdao.Update(id, bank);
		pw.println("<h1>Data updated successfully</h1>");

	}
}

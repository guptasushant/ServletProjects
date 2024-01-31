package com.web.bankcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bank.Bank;
import com.web.bankdao.BankDao;
import com.web.bankdaoimpl.BankDaoImpl;

public class BankController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	BankDao bankdao;
	PrintWriter pw;
	Bank bank;
	int idToDelete;
	int idTofetch;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		pw = resp.getWriter();
		bankdao = new BankDaoImpl();
		resp.setContentType("text/html");
		bank = new Bank();
		bank.setFirstname(req.getParameter("firstName"));
		bank.setLastname(req.getParameter("lastName"));
		bank.setAmount(req.getParameter("amount"));
		bankdao.Insert(bank);
		boolean success = bankdao.saveBank(bank);
		if (!success) {
			pw.println("<h6>Failed to save data in database</h6>");
		} else {
			pw.println("<h5>data save to database successfully</h5>");
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		pw = resp.getWriter();
		bankdao = new BankDaoImpl();
		bank = new Bank();
		int id = Integer.parseInt(req.getParameter("id"));
		String val = req.getParameter("work");
		if (val.equals("delete")) 
		{
			bankdao.Delete(id);
			pw.println("<h3>data deleted successfully</h3 >");
		} 
		else if (val.equals("fetch")) 
		{
			
			Bank fetch = bankdao.Fetch(id);
			if(fetch != null) {
				pw.print("<h1 align='center'>");
				pw.print("<br><br>");
				pw.println("First name :" + fetch.getFirstname());
				pw.print("<br><br>");
				pw.println("Last Name :" + fetch.getLastname());
				pw.print("<br><br>");
				pw.println("Amount :" + fetch.getAmount());
				pw.print("<br><br>");
				pw.println("Account Number :" + fetch.getAccount());
				pw.print("</h1>");
			}
			else 
			{				
				pw.println("<h2>data not found</h2>");
			}
		}
	}
	
}

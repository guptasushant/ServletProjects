package com.web.bankdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.bank.Bank;
import com.web.bankdao.BankDao;

public class BankDaoImpl implements BankDao {
	private Connection conn;
	private PreparedStatement statement;
	private Bank bank;

	public void Insert(Bank bank) {
		try {
			conn = ConnectionProvider.getConnection();
			String query = "INSERT into bank(firstName,lastName,amount,Account_No) Values(?,?,?,?)";
			statement = conn.prepareStatement(query);
			statement.setString(1, bank.getFirstname());
			statement.setString(2, bank.getLastname());
			statement.setString(3, bank.getAmount());
			statement.setString(4, bank.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void Delete(int id) {

		try {
			conn = ConnectionProvider.getConnection();
			String query = "DELETE FROM bank WHERE id=?";
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean saveBank(Bank bank) {
		return true;
	}

	public Bank Fetch(int id) {
		Bank bank = new Bank();
		try {
			conn = ConnectionProvider.getConnection();
			String query = "Select * from bank where id =?";
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				bank.setFirstname(resultSet.getString(2));
				bank.setLastname(resultSet.getString(3));
				bank.setAmount(resultSet.getString(4));
				bank.setAccount(resultSet.getString(5));
			} else {
				bank = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bank;

	}

	@Override
	public Bank Update(int id, Bank bank) {
		conn = ConnectionProvider.getConnection();
		String query = "UPDATE bank SET firstName=?,lastName=?,amount=? WHERE id=?";
		System.out.println("updated");
		try {
			statement = conn.prepareStatement(query);

			statement.setString(1, bank.getFirstname());
			statement.setString(2, bank.getLastname());
			statement.setString(3, bank.getAmount());
			statement.setInt(4, id);
			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bank;
	}

}
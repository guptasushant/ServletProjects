package com.newservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newservlet.bean.User;
import com.newservlet.connection.ConnectionProvider;

public class UserDaoImpl implements UserDao {

	public void Register(User user) {
		Connection conn = ConnectionProvider.getConnection();
		String query = "Insert into usercrud(name,email,phone_no,password) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone_no());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<User> fetch(User user) {
		Connection conn = ConnectionProvider.getConnection();
		String query = "select * from usercrud";
		ArrayList<User> list = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				user = new User();
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setPhone_no(set.getString("phone_no"));
				user.setPassword(set.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void update(User user) {

		Connection conn = ConnectionProvider.getConnection();
		String query = "update usercrud set email=?,phone_no=?,password=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPhone_no());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());
			System.out.println(user.getId());
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("data updated sucessfully");
			} else {
				System.out.println("error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(User user) {
		boolean found = false;
		Connection conn = ConnectionProvider.getConnection();
		String query = "delete from usercrud where id=? ";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.execute();
			if (!found) {
				System.out.println("Record not found !");
			} else {
				System.out.println("Record deleted successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package com.newservlet.dao;

import java.util.List;

import com.newservlet.bean.User;

public interface UserDao {
	void Register(User user);

	List<User> fetch(User user);

	void update(User user);

	void delete(User user);

}

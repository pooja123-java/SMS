package com.Pratice.Service;

import java.sql.SQLException;

import com.Practice.User.User;

public interface UserServices {
	int saveUser(User user) throws SQLException;
	void login(User user);
	void loginByName(User user);
	void loginById(User user);

}

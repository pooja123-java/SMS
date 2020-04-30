package com.Practice.UserServiceImpl;

import java.sql.SQLException;

import com.Practice.DataLayer.DataLayer;
import com.Practice.User.User;
import com.Pratice.Service.UserServices;

public class UserServiceImpl implements UserServices {
	DataLayer layer;

	@Override
	public int saveUser(User user) throws SQLException {
		return layer.insertUser(user);
	
	}

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginByName(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginById(User user) {
		// TODO Auto-generated method stub

	}

}

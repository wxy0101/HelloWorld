package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.bean.User;

public interface Dao {

	User checkUsernameAndPassword(User user);
	boolean checkUsername(User user);
	void saveUser(User user);

}

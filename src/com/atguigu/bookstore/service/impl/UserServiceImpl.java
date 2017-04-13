package com.atguigu.bookstore.service.impl;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.dao.Dao;
import com.atguigu.bookstore.dao.impl.DaoImpl;
import com.atguigu.bookstore.service.UserService;

public class UserServiceImpl implements UserService {
	private Dao dao=new DaoImpl();
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return dao.checkUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		return dao.checkUsername(user);
	}

	@Override
	public void save(User user) {
		dao.saveUser(user);
	}

}
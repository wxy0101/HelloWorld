package com.atguigu.bookstore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.Dao;

public class DaoImpl extends BaseDao<User> implements Dao{

	public User checkUsernameAndPassword(User user) {
		String sql="select id,username,password,email from users where username=? and password=?";
		User bean = getBean(sql,user.getUsername(),user.getPassword());
		return bean;
	}


	public boolean checkUsername(User user) {
		String sql="select id,username,password,email from users where username=?";
		User bean = getBean(sql,user.getUsername());
		return bean==null;
	}


	public void saveUser(User user) {
		String sql="insert into users(username,password,email) values(?,?,?)";
		update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

}

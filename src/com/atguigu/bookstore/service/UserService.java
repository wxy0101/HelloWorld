package com.atguigu.bookstore.service;

import com.atguigu.bookstore.bean.User;

public interface UserService {
	public User login(User user);
	public boolean regist(User user);
	public void save(User user);
	
}

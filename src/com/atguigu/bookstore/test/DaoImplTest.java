package com.atguigu.bookstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.dao.impl.DaoImpl;

public class DaoImplTest {
	private DaoImpl dao=new DaoImpl();

	@Test
	public void testCheckUsernameAndPassword() {
		User user=new User(null,"admin","123456","email11");
		User user2 = dao.checkUsernameAndPassword(user);
		System.out.println(user2);
		
	}

	@Test
	public void testCheckUsername() {
		User user=new User(null,"admin","123456","email11");
		boolean b = dao.checkUsername(user);
		System.out.println(b);

	}
	@Test
	public void testSaveUser() {
		User user=new User(null,"admin1","123456","email11");
		dao.saveUser(user);
	}

}

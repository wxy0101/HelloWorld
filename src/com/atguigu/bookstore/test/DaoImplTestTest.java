package com.atguigu.bookstore.test;


import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;

public class DaoImplTestTest {

	@Test
	public void test() {
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<Book> book = bookDaoImpl.getBooks();
		for (Book book2 : book) {
			System.out.println(book2);
		}
	}
	@Test
	public void haha(){
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		Page<Book> page = new Page<>();
		page.setPageNo(2);
		Page<Book> page1=bookDaoImpl.getPageBooksByPrice(page,10,30);
		List<Book> list = page1.getList();
		System.out.println(list);
		
	}

}

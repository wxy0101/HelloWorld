package com.atguigu.bookstore.service.impl;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDaoImpl bdi=new BookDaoImpl();

	@Override
	public List<Book> getBookList() {
		List<Book> books = bdi.getBooks();
		return books;
	}
	@Override
	public void addBook(Book book) {
		bdi.addBook(book);
	}
	@Override
	public void deleteBookById(String bookId) {
		bdi.deleteBookById(bookId);
	}
	@Override
	public Book getBook(String id) {
		return bdi.getBook(id);
	}
	@Override
	public void saveBook(Book book) {
		bdi.saveBook(book);
	}
	@Override
	public Page<Book> getPageBook(String pageNum) {
		int defaultNum=1;
		try {
			defaultNum = Integer.parseInt(pageNum);
		} catch (Exception e) {}
		Page<Book> page = new Page<Book>();
		page.setPageNo(defaultNum);
		return bdi.getPageBook(page);
	}
	@Override
	public Page<Book> getPageBooksByPrice(String pageNum, String minPrice,
			String maxPrice) {
		int defaultNum=1;
		double defaultMinPrice=0;
		double defaultMaxPrice=Double.MAX_VALUE;
		try {
			defaultNum = Integer.parseInt(pageNum);
		} catch (Exception e) {}
		try {
			defaultMinPrice=Double.parseDouble(minPrice);
		} catch (Exception e) {}
		try {
			defaultMaxPrice=Double.parseDouble(maxPrice);
		} catch (Exception e) {}
		Page<Book> page = new Page<Book>();
		page.setPageNo(defaultNum);
		return bdi.getPageBooksByPrice(page, defaultMinPrice, defaultMaxPrice);
	}



}

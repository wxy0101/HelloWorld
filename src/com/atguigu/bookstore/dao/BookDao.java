package com.atguigu.bookstore.dao;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;

public interface BookDao {
	public List<Book> getBooks();
	public void addBook(Book book);
	public void deleteBookById(String bookId);
	public Book getBook(String id);
	public void saveBook(Book book);
	public Page<Book> getPageBook(Page<Book> page);
	public Page<Book> getPageBooksByPrice(Page<Book> page,double minPrice,double maxPrice);
}

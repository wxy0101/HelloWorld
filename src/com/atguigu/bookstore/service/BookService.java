package com.atguigu.bookstore.service;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;

public interface BookService {
	public List<Book> getBookList();
	public void addBook(Book book);
	public void deleteBookById(String bookId);
	public Book getBook(String id);
	public void saveBook(Book book);
	public Page<Book> getPageBook(String pageNum);
	public Page<Book> getPageBooksByPrice(String pageNum,String minPrice,String maxPrice);
}

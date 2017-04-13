package com.atguigu.bookstore.dao.impl;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao{


	@Override
	public List<Book> getBooks() {
		String sql="select id,title,price, author,sales,stock,img_path imgPath from books";
		List<Book> list = getBeanList(sql);
		return list;
	}

	@Override
	public void addBook(Book book) {
		String sql="insert into books(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
		update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public void deleteBookById(String bookId) {
		String sql="delete from books where id=?";
		update(sql, bookId);
	}

	@Override
	public Book getBook(String id) {
		String sql="select id,title,price, author,sales,stock,img_path imgPath from books where id=?";
		Book bean = getBean(sql, id);
		return bean;
	}

	@Override
	public void saveBook(Book book) {
		String sql="update books set title=?, price=?,author=?,sales=?,stock=? where id=?";
		update(sql, book.getTitle(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getId());
		
	}

	@Override
	public Page<Book> getPageBook(Page<Book> page) {
		
		
		String sql="select count(*) from books";
		long singleValue = (long) getSingleValue(sql);
		
		page.setTotalRecord((int)(singleValue));
		
		String sql2="select id,title,price, author,sales,stock,img_path imgPath from books limit ?,?";
		List<Book> list = getBeanList(sql2, (page.getPageNo()-1)*Page.getPageSize(),Page.getPageSize());
		page.setList(list);
		
		return page;
	}

	@Override
	public Page<Book> getPageBooksByPrice(Page<Book> page,double minPrice,double maxPrice) {
		String sql="select count(*) from books where price between ? and ?";
		long singleValue = (long) getSingleValue(sql,minPrice,maxPrice);
		
		page.setTotalRecord((int)(singleValue));
		
		String sql2="select id,title,price, author,sales,stock,img_path imgPath from books where price between ? and ? limit ?,?";
		List<Book> list = getBeanList(sql2,minPrice,maxPrice, (page.getPageNo()-1)*Page.getPageSize(),Page.getPageSize());
		page.setList(list);
		
		return page;
	}

	

	

}

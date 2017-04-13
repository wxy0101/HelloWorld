package com.atguigu.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;
import com.atguigu.bookstore.utils.WEBUtils;
import com.sun.xml.internal.bind.CycleRecoverable.Context;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookServiceImpl bsi=new BookServiceImpl();
	private Book book;
	//此服务器用于通过id删除图书
	protected void deleteBookById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("id");
		System.out.println();
		bsi.deleteBookById(bookId);
		getBooks(request,response);

	}
	//此方法用于获取所有图书
	protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list = bsi.getBookList();
		request.setAttribute("bookservlet", list);
		request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request, response);

	}
	//此方法用于获取某一页的图书
	
	//	此方法用于获取一本图书
	protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Book book = bsi.getBook(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("pages/manager/book_edit.jsp").forward(request, response);
	}
	//此方法通过id是否为空而判断是修改还是添加一本图书
	protected void saveOrAddBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("book_name");
		String price = request.getParameter("book_price");
		String author = request.getParameter("book_author");
		String sales = request.getParameter("book_sales");
		String stock = request.getParameter("book_amount");
		String id=request.getParameter("id");
		if("".equals(id)){
			Book book2 = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));

			bsi.addBook(book2);
			response.sendRedirect(request.getContextPath() + "/BookServlet?method=getPageBook");
		}else{
			Book book2 = new Book(new Integer(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
			bsi.saveBook(book2);
			response.sendRedirect(request.getContextPath() + "/BookServlet?method=getPageBook");
		}



	}
	protected void getPageBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path=WEBUtils.getPath(request);

		String pageNum = request.getParameter("pageNo");
		Page<Book> pageBook = bsi.getPageBook(pageNum);
		pageBook.setPath(path);
		request.setAttribute("bookservlet", pageBook);
		request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request, response);
	}
	//此方法用于前端界面的数据库图书的获取
	




}

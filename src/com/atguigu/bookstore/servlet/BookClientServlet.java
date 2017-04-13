package com.atguigu.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.service.impl.BookServiceImpl;
import com.atguigu.bookstore.utils.WEBUtils;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookServiceImpl bsi=new BookServiceImpl();
	private Book book;
      //获取某一页的书
	protected void getPageBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path=WEBUtils.getPath(request);

		String pageNum = request.getParameter("pageNo");
		Page<Book> pageBook = bsi.getPageBook(pageNum);
		pageBook.setPath(path);
		request.setAttribute("bookservlet", pageBook);
		request.getRequestDispatcher("WEB-INF/include/index.jsp").forward(request, response);
	}
	
	
	protected void getPageBooksByPrice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path=WEBUtils.getPath(request);
		System.out.println(path);
		String pageNum = request.getParameter("pageNo");
		String minPrice=request.getParameter("min");
		String maxPrice=request.getParameter("max");
		
		
		Page<Book> pageBook = bsi.getPageBooksByPrice(pageNum, minPrice, maxPrice);
		pageBook.setPath(path);
		request.setAttribute("bookservlet", pageBook);
		request.getRequestDispatcher("WEB-INF/include/index.jsp").forward(request, response);
	}

}

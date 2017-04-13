package com.atguigu.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
   

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User(null,username,password,null);
		User login=userService.login(user);
		if(login!=null){
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}else{
			request.setAttribute("error", "�û��������벻��ȷ");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}

	}
    
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user = new User(null, username, password, email);
		boolean b = userService.regist(user);
		if(b){
			userService.save(user);
			//�ض���ע��ɹ�ҳ��
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			request.setAttribute("registerror", "�û����ظ���ע��ʧ��");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	
	}
    

}

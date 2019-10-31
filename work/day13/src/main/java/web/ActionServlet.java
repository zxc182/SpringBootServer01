package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//获得请求资源路径
		String uri = request.getRequestURI();
		//截取请求资源路径的一部分，方便比较
		String path = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		System.out.println("path:" + path);
		
		//依据请求路径进行相应处理
		if("/login".equals(path)){
			processLogin(request,response);
		}else if("/list".equals(path)){
			processList(request,response);
		}else if("/del".equals(path)){
			processDel(request,response);
		}else if("/add".equals(path)){
			processAdd(request,response);
		}else if("/toLogin".equals(path)){
			request.getRequestDispatcher(
					"/WEB-INF/login.jsp")
			.forward(request, response);
		}else if("/toAdd".equals(path)){
			request.getRequestDispatcher(
					"/WEB-INF/addUser.jsp")
			.forward(request, response);
		}
		
	}


	private void processAdd(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if(obj == null){
			//没有登录，重定向到登录页面
			response.sendRedirect("toLogin.do");
			return;
		}
		
		String username = 
				request.getParameter("username");
		String pwd = 
				request.getParameter("pwd");
		String email = 
				request.getParameter("email");
		
		//将用户信息插入到数据库
		UserDAO dao = new UserDAO();
		try {
			User user = new User();
			user.setUsername(username);
			user.setPwd(pwd);
			user.setEmail(email);
			dao.save(user);
			//重定向到用户列表
			response.sendRedirect("list.do");
			
		} catch (SQLException e) {
			//记日志(保留现场)
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}


	private void processDel(
			HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if(obj == null){
			//没有登录，重定向到登录页面
			response.sendRedirect("toLogin.do");
			return;
		}
		
		//读取要删除的用户的id
		int id = 
				Integer.parseInt(
						request.getParameter("id"));
		//删除指定id的用户
		UserDAO dao = new UserDAO();
		try {
			dao.delete(id);
			//重定向到用户列表
			response.sendRedirect("list.do");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}


	private void processList(
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		/*
		 * 查看用户有没有登录，只有登录过的用户才能访问
		 * 用户列表。
		 */
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if(obj == null){
			//没有登录，重定向到登录页面
			response.sendRedirect("toLogin.do");
			return;
		}
		UserDAO dao = new UserDAO();
		try {
			List<User> users = dao.findAll();
			//绑订数据到request对象上
			request.setAttribute("users", users);
			//获得转发器
			RequestDispatcher rd= 
					request.getRequestDispatcher(
							"/WEB-INF/listUser.jsp");	
			//转发
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}


	private void processLogin(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, ServletException {
		
		//读取用户名和密码
		String username = 
				request.getParameter("username");
		String pwd = 
				request.getParameter("pwd");
		//查看数据库，看有没有匹配条件的记录
		UserDAO dao = new UserDAO();
		try {
			User user = dao.find(username);
			if(user != null 
					&& user.getPwd().equals(pwd)){
				//有匹配条件的记录，登录成功
				HttpSession session = 
						request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("list.do");
			}else{
				//登录失败
				request.setAttribute("login_failed",
						"用户名或密码错误");
				request.getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//将异常抛给容器来处理
			throw new ServletException(e);
		}
		
	}

}

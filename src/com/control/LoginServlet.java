package com.control;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.UserDao;
import com.modal.User;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="LoginServlet",urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, 
HttpServletResponse response)
               throws ServletException, IOException {
	  response.setHeader("Content-Type","text/html;charset=UTF-8");//设置中文编码
      String message="";
      String userNo = request.getParameter("userNo");
      String password = request.getParameter("password");
      // 用户名和密码对应正确，认为登录成功
      UserDao dao = new UserDao();
      User user =dao.findByName(userNo);
      if(user.password==null)
      {
    	  message="用户不存在！";
    	  request.setAttribute("message", message);
          RequestDispatcher rd = 
request.getRequestDispatcher("/pages/Login.jsp");
         rd.forward(request, response);
      }
      else if(password.equals(user.password)){
    	  request.setAttribute("userNo", user.userNo);
    	  request.setAttribute("roleNo", user.roleNo);
          RequestDispatcher rd = 
request.getRequestDispatcher("/pages/Home.jsp");
         rd.forward(request, response);
      }else{
    	  message="密码错误！";
    	  request.setAttribute("message", message);
          RequestDispatcher rd = 
request.getRequestDispatcher("/pages/Login.jsp");
         rd.forward(request, response);
      }
      dao.destroy();
   }
}
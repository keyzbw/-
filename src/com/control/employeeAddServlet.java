package com.control;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.UserDao;
import com.modal.User;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="employeeAddServlet",urlPatterns={"/empolyeeAdd.do"})
public class employeeAddServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, 
HttpServletResponse response)
               throws ServletException, IOException {
	  response.setHeader("Content-Type","text/html;charset=UTF-8");//…Ë÷√÷–Œƒ±‡¬Î
	  User user=new User();
      user.userNo = request.getParameter("employeeNo");
      System.out.println(user.userNo);
      user.roleNo = request.getParameter("roleNo");
      user.userName = request.getParameter("employeeName");
      user.password = request.getParameter("password");

      UserDao dao=new UserDao();
      boolean res=dao.addEmployee(user);
      PrintWriter out = response.getWriter();
      out.print(res);
      out.close();
      dao.destroy();
   }
}
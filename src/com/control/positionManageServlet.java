package com.control;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.RoleDao;
import com.modal.Role;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="positionManageServlet",urlPatterns={"/positionManage.do"})
public class positionManageServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, 
HttpServletResponse response)
               throws ServletException, IOException {
	  response.setHeader("Content-Type","text/html;charset=UTF-8");//设置中文编码
      String roleNo = request.getParameter("roleNo");
      // 用户名和密码对应正确，认为登录成功
      RoleDao dao = new RoleDao();
      Role role =dao.findByNo(roleNo);
      int fadd=0,fdelete=0,fmodify=0;
      for(int i=0;i<role.functionNum;i++) {
    	  if(role.functionNo[i].equals("32783"))
    		 fadd=1;
    	  if(role.functionNo[i].equals("32784"))
    		  fdelete=1;
    	  if(role.functionNo[i].equals("32786"))
    		  fmodify=1;
      }
      request.setAttribute("functionAdd", fadd);
      request.setAttribute("functionDelete", fdelete);
      request.setAttribute("functionModify", fmodify);
      RequestDispatcher rd = 
request.getRequestDispatcher("/pages/positionManage.jsp");
     rd.forward(request, response);
      
      dao.destroy();
   }
}
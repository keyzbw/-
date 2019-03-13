package com.control;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.RoleDao;
import com.modal.Role;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="roleAdd",urlPatterns={"/roleAdd.do"})
public class roleAdd extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, 
HttpServletResponse response)
               throws ServletException, IOException {
	  response.setHeader("Content-Type","text/html;charset=UTF-8");//…Ë÷√÷–Œƒ±‡¬Î
	  Role role=new Role();
      role.roleNo = request.getParameter("roleNo");
      role.roleName = request.getParameter("roleName");
      role.functionNo[0] = request.getParameter("function0");
      role.functionNo[1]=request.getParameter("function1");
      role.functionNo[2]=request.getParameter("function2");
      role.functionNo[3]=request.getParameter("function3");
      role.functionNo[4]=request.getParameter("function4");
      role.functionNo[5]=request.getParameter("function5");
      role.functionNo[6]=request.getParameter("function6");
      role.functionNo[7]=request.getParameter("function7");
      
      RoleDao dao=new RoleDao();
      boolean res=dao.addRole(role);
	  if(res) {
          for(int i=0;i<8;i++) {
    	      if(role.functionNo[i]!=null)
    	    	  dao.addRight(role.roleNo, role.functionNo[i]);
          }
      }
 
      PrintWriter out = response.getWriter();
      out.print(res);
      out.close();
      dao.destroy();
   }
}
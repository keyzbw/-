package com.control;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.RoleDao;
import com.modal.Role;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="employeeManageServlet",urlPatterns={"/empolyeeManage.do"})
public class employeeManageServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, 
HttpServletResponse response)
               throws ServletException, IOException {
	  response.setHeader("Content-Type","text/html;charset=UTF-8");//�������ı���
      String roleNo = request.getParameter("roleNo");
      // �û����������Ӧ��ȷ����Ϊ��¼�ɹ�
      RoleDao dao = new RoleDao();
      Role role =dao.findByNo(roleNo);
      int fadd=0,fdelete=0,fmodify=0;
      for(int i=0;i<role.functionNum;i++) {
    	  if(role.functionNo[i].equals("32775"))
    		 fadd=1;
    	  if(role.functionNo[i].equals("32776"))
    		  fdelete=1;
    	  if(role.functionNo[i].equals("32777"))
    		  fmodify=1;
      }
      request.setAttribute("functionAdd", fadd);
      request.setAttribute("functionDelete", fdelete);
      request.setAttribute("functionModify", fmodify);
      RequestDispatcher rd = 
request.getRequestDispatcher("/pages/employeeManage.jsp");
     rd.forward(request, response);
      
      dao.destroy();
   }
}
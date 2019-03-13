package com.control;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.RoleDao;
import com.modal.Role;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="saleManageServlet",urlPatterns={"/saleManage.do"})
public class saleManageServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, 
HttpServletResponse response)
               throws ServletException, IOException {
	  response.setHeader("Content-Type","text/html;charset=UTF-8");//�������ı���
      String roleNo = request.getParameter("roleNo");
      // �û����������Ӧ��ȷ����Ϊ��¼�ɹ�
      RoleDao dao = new RoleDao();
      Role role =dao.findByNo(roleNo);
      int fsale=0,fstore=0;
      for(int i=0;i<role.functionNum;i++) {
    	  if(role.functionNo[i].equals("32773"))
    		 fsale=1;
    	  if(role.functionNo[i].equals("32772"))
    		 fstore=1;
      }
      request.setAttribute("functionSale", fsale);
      request.setAttribute("functionStore", fstore);
      RequestDispatcher rd = 
request.getRequestDispatcher("/pages/sale.jsp");
     rd.forward(request, response);
      
      
      
      dao.destroy();
   }
}
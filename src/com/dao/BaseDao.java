package com.dao;

import java.sql.*;

public class BaseDao {
	Connection conn = null;
   // �ڹ��췽���з�������Դ����
public BaseDao () {
    String driver = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://localhost:3306/rightsystem?useSSL=true&serverTimezone=GMT%2B8";
    String username = "root";
    String password = "123456";
    
    try{
Class.forName(driver); // ������������
        // �������Ӷ���
conn = DriverManager.getConnection(
    	                     dburl,username,password);
    }catch(ClassNotFoundException e1){
        System.out.println(e1);
    }catch(SQLException e2){}
}
public void destroy(){
    try {
       conn.close();
    }catch(Exception e){
	     e.printStackTrace();
}
}
}
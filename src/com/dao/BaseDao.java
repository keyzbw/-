package com.dao;

import java.sql.*;

public class BaseDao {
	Connection conn = null;
   // 在构造方法中返回数据源对象
public BaseDao () {
    String driver = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://localhost:3306/rightsystem?useSSL=true&serverTimezone=GMT%2B8";
    String username = "root";
    String password = "123456";
    
    try{
Class.forName(driver); // 加载驱动程序
        // 创建连接对象
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
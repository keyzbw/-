package com.dao;
import java.sql.*;
import com.modal.User;

public class UserDao extends BaseDao{
   // 插入一条用户记录
   public boolean addEmployee(User user){  	  
   	   String sql = "INSERT INTO user" +
   	   		" VALUES(?,?,?,?)";	
   	   try(
   		 PreparedStatement pstmt = conn.prepareStatement(sql))//设置属性值，执行查询语句
   	   { 
   	     pstmt.setString(1,user.userNo);
   	     pstmt.setString(2,user.userName);
   	     pstmt.setString(3,user.password);
   	     pstmt.setString(4,user.roleNo);
   	     pstmt.executeUpdate();
   	     return true;
   	   }catch(SQLException se){
   	  	  se.printStackTrace();
   		  return false;
   	   }
   } 
   
   // 按姓名检索用户信息
   public User findByName(String userNo){ 
	   User user = new User();
	      try{
	        String sql="SELECT * FROM user WHERE userNo = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1,userNo);
	        ResultSet rst = pstmt.executeQuery();
		      
	        if(rst.next()){
	           user.userNo=rst.getString("userNo");
	           user.userName=rst.getString("userName");
	           user.password=rst.getString("password");
	           user.roleNo=rst.getString("roleNo");
	        }
	      }catch(SQLException e){
	  	      e.printStackTrace();
	      }
		return user;
   }
}
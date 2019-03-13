package com.dao;
import java.sql.*;
import com.modal.Role;


public class RoleDao extends BaseDao{
	public Role findByNo(String roleNo){ 
		   Role role = new Role();
		      try{
		        String sql="SELECT * FROM role a,role_function b WHERE a.roleNo = ? AND a.roleNo=b.roleNo";
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1,roleNo);
		        ResultSet rst = pstmt.executeQuery();
		        int i=0;
		        while(rst.next()){
		           role.roleNo=rst.getString("roleNo");
		           role.roleNo=rst.getString("roleName");
		           role.functionNo[i]=rst.getString("functionNo");
		           i++;
		        }
		        role.functionNum=i;
		      }catch(SQLException e){
		  	      e.printStackTrace();
		      }
			return role;
	   }
	
	public boolean addRole(Role role){  	  
	   	   String sql = "INSERT INTO role" +
	   	   		" VALUES(?,?)";	
	   	   try(
	   		 PreparedStatement pstmt = conn.prepareStatement(sql))//设置属性值，执行查询语句
	   	   { 
	   	     pstmt.setString(1,role.roleNo);
	   	     pstmt.setString(2,role.roleName);
	   	     pstmt.executeUpdate();
	   	     return true;
	   	   }catch(SQLException se){
	   	  	  se.printStackTrace();
	   		  return false;
	   	   }
	   } 
	
	public boolean addRight(String roleNo,String functionNo){  	  
	   	   String sql = "INSERT INTO role_function" +
	   	   		" VALUES(?,?,'001')";	
	   	   try(
	   		 PreparedStatement pstmt = conn.prepareStatement(sql))//设置属性值，执行查询语句
	   	   { 
	   	     pstmt.setString(1,roleNo);
	   	     pstmt.setString(2,functionNo);
	   	     pstmt.executeUpdate();
	   	     return true;
	   	   }catch(SQLException se){
	   	  	  se.printStackTrace();
	   		  return false;
	   	   }
	   } 
}
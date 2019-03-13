package com.modal;
import java.io.Serializable;
@SuppressWarnings("serial")
public class User implements Serializable {
public String userNo;
public String userName;
public String password;
public String roleNo;
public User() { }
public User(String userNo, String userName, String password,String roleNo) {
          this.userNo = userNo;
	      this.userName = userName;
	      this.password = password;
	      this.roleNo=roleNo;
}
}
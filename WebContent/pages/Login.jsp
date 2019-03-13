<%@ page contentType="text/html; charset=utf-8"
            pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>权限系统</title>
    <link href="/RightSystem/css/Login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkSubmit(form){  
    if (form.user_id.value==""){  
 	   alert("请输入用户名！");  
        return false;  
     }  
     else if (form.password.value==""){  
         alert("请输入密码！");  
         return false;  
     }  
}
</script> 
</head>

<body style="background-color:#df7611; background-image:url(/RightSystem/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div align="center" class="container">

<div class="logintop">    
    <span>欢迎登录权限管理界面平台</span>      
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form  method="POST"  action="/RightSystem/login.do" onsubmit="return checkSubmit(this);">
    <ul>
    <li><input id="userNo" name="userNo" type="text" class="loginuser" value="" placeholder="用户名" /></li>
    <li><input id="password" name="password" type="text" class="loginpwd" value="" placeholder="密码" /></li>
    <li><input  type="submit" class="loginbtn" value="登录"    />
    <label><input name="" type="checkbox" value="" checked="checked" />记住密码</label>
    <label><a href="#">忘记密码？</a></label></li>
    </ul>
    </form>
    </div>
    
    </div>
    </div>
<%
String message = (String)request.getAttribute("message");         // 获取错误属性
if(message != null) {
%>
<script type="text/javascript">
alert("<%=message%>");       
</script>
<%
}
%>

</body>
</html>








<%@ page contentType="text/html; charset=utf-8"
            pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/RightSystem/css/content.css" rel="stylesheet" type="text/css" />
<%String userName = (String)request.getAttribute("userNo"); %>
<title>Insert title here</title>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="/RightSystem/images/sun.png" alt="天气" /></span>
    <b><%=userName %>早上好，欢迎使用权限管理系统</b>
    <a href="#">帐号设置</a>
    </div>
    </div>
</body>
</html>
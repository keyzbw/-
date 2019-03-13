<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>head</title>
<link  rel="stylesheet" href="/RightSystem/css/head.css"/>
<script type="text/javascript">

</script>
<%
String userName = (String)request.getParameter("userNo");         // 获取用户名
String roleNo = (String)request.getParameter("roleNo");         // 获取职位号
%>
</head>
<body style="background:url(/RightSystem/images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="main.html" target="_parent"><img src="/RightSystem/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="/RightSystem/saleManage.do?roleNo=<%=roleNo %>" target="rightFrame" class="selected"><img src="/RightSystem/images/icon01.png" title="库存管理" /><h2>库存管理</h2></a></li>
    <li><a href="/RightSystem/empolyeeManage.do?roleNo=<%=roleNo %>" target="rightFrame"><img src="/RightSystem/images/icon02.png" title="员工管理" /><h2>员工管理</h2></a></li>
    <li><a href="/RightSystem/positionManage.do?roleNo=<%=roleNo %>"  target="rightFrame"><img src="/RightSystem/images/icon03.png" title="职位管理" /><h2>职位管理</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="/RightSystem/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="/RightSystem/pages/Login.jsp" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span><%=userName %></span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div> 
</body>
</html>
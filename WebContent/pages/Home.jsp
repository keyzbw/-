<%@ page contentType="text/html; charset=utf-8"
            pageEncoding="utf-8"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>权限系统</title>
    <link  rel="stylesheet" href="/RightSystem/css/home.css"/>
<%String userNo = (String)request.getAttribute("userNo"); %>
<%String roleNo = (String)request.getAttribute("roleNo"); %>
</head>
<frameset rows="88,*,31" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="/RightSystem/pages/head.jsp?userNo=<%=userNo%>&roleNo=<%=roleNo %>" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
    <frame src="/RightSystem/pages/content.jsp?userNo=<%=userNo%>" name="rightFrame" id="rightFrame" title="rightFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>
<%@ page contentType="text/html; charset=utf-8"
            pageEncoding="utf-8"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工管理</title>
<link href="/RightSystem/css/employeeManage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/RightSystem/js/jquery.js"></script>
<%
int functionAdd = (int)request.getAttribute("functionAdd");
int functionDelete = (int)request.getAttribute("functionDelete");
int functionModify = (int)request.getAttribute("functionModify");
%>
<script type="text/javascript">
function addEmployee(){
	 $.ajax({
         type: "POST",
         url: "http://localhost:8080/RightSystem/empolyeeAdd.do",
         data: {
        	 employeeNo:$("#employeeNo").val(),
        	 employeeName:$("#employeeName").val(),
        	 password:$("#password").val(),
        	 roleNo:$("#roleNo").val(),
         },
         success: function(res){
        	 if(res=="true")
                 window.confirm("添加成功！");
         	else
         		window.confirm("添加出错！");
         },
         fail:function(e){
        	 alter("添加出错！");
         }
     });
}
</script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">员工管理</a></li>
    </ul>
</div>
    
<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<%if(functionAdd==1) {%>
        <li class="click" onclick="addEmployee()"><span><img src="/RightSystem/images/t01.png" /></span>添加</li>
        <%} %>
        <%if(functionModify==1) {%>
        <li class="click" onclick=""><span><img src="/RightSystem/images/t02.png" /></span>修改</li>
        <%} %>
        <%if(functionDelete==1) {%>
        <li class="click" onclick=""><span><img src="/RightSystem/images/t03.png" /></span>删除</li>
        <%}%>
        </ul>
    </div>
    
    <div class="tools">
        <form action="#">
        <input type="text" id="inquerNo" name="inquerNo" placeholder="请输入员工编号"></input>
        <button type="submit" class="click">查询</button>
        </form>
    </div>
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="150px;">员工编号</th>
    <th width="150px;">员工姓名</th>
    <th width="150px;">员工密码</th>
    <th width="150px;">员工职位号</th>
    </tr>
    </thead>
    
    <tbody>
    
    <tr>
    <td><input type="text" id="employeeNo" name="employeeNo"></input></td>
    <td><input type="text" id="employeeName" name="employeeName"></input></td>
    <td><input type="text" id="password" name="password"></input></td>
    <td><input type="text" id="roleNo" name="roleNo"></input></td>
    </tr>
    
    </tbody>
    
    </table>
    
</div>
    
</body>
</html>
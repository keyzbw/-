<%@ page contentType="text/html; charset=utf-8"
            pageEncoding="utf-8"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位管理</title>
<link href="/RightSystem/css/positionManage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/RightSystem/js/jquery.js"></script>
<%
int functionAdd = (int)request.getAttribute("functionAdd");
int functionDelete = (int)request.getAttribute("functionDelete");
int functionModify = (int)request.getAttribute("functionModify");
%>
<script type="text/javascript">
function addRole(){
	var funcs=document.getElementsByName("func");                 
	var funcNo=new Array(8);
	for(var i=0;i<8;i++){
		if(funcs[i].checked){
			funcNo[i]=funcs[i].value;
		}
	}
	$.ajax({
       type: "POST",
        url: "http://localhost:8080/RightSystem/roleAdd.do",
        data: {
       	 roleNo:$("#roleNo").val(),
       	 roleName:$("#roleName").val(),
       	 function0:funcNo[0],
       	 function1:funcNo[1],
       	 function2:funcNo[2],
       	 function3:funcNo[3],
       	 function4:funcNo[4],
       	 function5:funcNo[5],
       	 function6:funcNo[6],
       	 function7:funcNo[7],
         },
        success: function(res){
        	if(res=="true")
                window.confirm("添加成功！");
        	else
        		window.confirm("添加出错！");
        },
        fail:function(e){
        	window.confirm("添加出错！");
        }
    });
}
</script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">职位管理</a></li>
    </ul>
</div>
    
<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<%if(functionAdd==1) {%>
        <li class="click" onclick="addRole()"><span><img src="/RightSystem/images/t01.png" /></span>添加</li>
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
        <input type="text" id="userNo" name="userNo" placeholder="请输入职位编号"></input>
        <button type="submit" class="click">查询</button>
        </form>
    </div>
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="50px;">职位编号</th>
    <th width="50px;">职位名称</th>
    <th width="250px;">职位权限</th>
    </tr>
    </thead>
    
    <tbody>
    
    <tr>
    <td><input type="text" id="roleNo" name="roleNo"></input></td>
    <td><input type="text" id="roleName" name="roleName"></input></td>
    <td><input type="checkbox"  name="func" value="32772">入库
    <input type="checkbox"  name="func" value="32773">出库
    <input type="checkbox"  name="func" value="32775">添加员工
    <input type="checkbox"  name="func" value="32777">修改员工
    <input type="checkbox"  name="func" value="32776">删除员工
    <input type="checkbox"  name="func" value="32783">添加职位
    <input type="checkbox"  name="func" value="32786">修改职位
    <input type="checkbox"  name="func" value="32784">删除职位</td>
    </tr>
    
    </tbody>
    
    </table>
    
</div>
    
</body>
</html>
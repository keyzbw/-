<%@ page contentType="text/html; charset=utf-8"
            pageEncoding="utf-8"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/RightSystem/css/sale.css" rel="stylesheet" type="text/css" />
<%
int functionSale = (int)request.getAttribute("functionSale");
int functionStore = (int)request.getAttribute("functionStore");
%>
<script type="text/javascript">
</script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">库存管理</a></li>
    </ul>
</div>
    
<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<%if(functionSale==1) {%>
        <li class="click" onclick="buttonAdd()"><span><img src="/RightSystem/images/t01.png" /></span>入库</li>
        <%} %>
        <%if(functionStore==1) {%>
        <li class="click" onclick="buttonAdd()"><span><img src="/RightSystem/images/t03.png" /></span>出库</li>
        <%}%>
        </ul>
    </div>
    
    <div class="tools">
        <form action="#">
        <input type="text" id="userNo" name="userNo" placeholder="请输入产品编号"></input>
        <button type="submit" class="click">查询</button>
        </form>
    </div>
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="150px;">商品编号</th>
    <th width="150px;">商品名称</th>
    <th width="150px;">库存数量</th>
    <th width="150px;">价格</th>
    </tr>
    </thead>
    
    <tbody>
    
    
    </tbody>
    
    </table>
    
</div>
    
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-05-30
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link rel="stylesheet" href="css/patient.css">
<body>
<h3>当前位置：操作记录</h3>
<hr>
<jsp:include page="header_user.jsp"></jsp:include>
<table class="table table-hover text-center">
    <tbody><tr>
        <th width="10%">医生ID</th>
        <th width="10%">患者ID</th>
        <th width="10%">挂号单号</th>
        <th width="10%">取药单号</th>
        <th width="10%">费用单号</th>


    </tr>

    </tbody></table>
<!--分页-->
<jsp:include page="footer_style.jsp"></jsp:include>
</body>
</html>


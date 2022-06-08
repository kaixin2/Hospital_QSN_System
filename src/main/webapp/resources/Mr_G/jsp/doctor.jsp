<%@ page import="com.example.Mr_G.model.Doctor" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-05-30
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css\patient.css">
<body>
<h3 >当前位置：医生管理</h3>
<hr>
<jsp:include page="header_doctor.jsp"></jsp:include>
<%

    request.setCharacterEncoding("utf-8");
    List <Doctor> list=(List<Doctor>)request.getAttribute("allInfor");

%>

<table class="table table-hover text-center">
    <tbody><tr>
        <th width="10%">ID</th>
        <th width="10%">姓名</th>
        <th width="10%">医科</th>
        <th width="10%">诊室</th>
        <th width="10%">工作时间</th>
        <th width="10%">联系方式</th>

    </tr>
    <%
        if(list!=null){
            for(int i=0;i<list.size();i++){
    %>
    <tr>
        <td><%=list.get(i).getID()%></td>
        <td><%=list.get(i).getName() %></td>
        <td><%=list.get(i).getCourse() %></td>
        <td><%=list.get(i).getRoom() %></td>
        <td><%=list.get(i).getTime() %></td>
        <td><%=list.get(i).getTelephone() %></td>
            <%  }
			} %>
    </tbody></table>
<!--分页-->

<jsp:include page="footer_style.jsp"></jsp:include>

</body>
</html>


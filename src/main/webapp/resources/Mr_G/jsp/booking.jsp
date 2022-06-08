<%@ page import="com.example.Mr_G.model.Booking" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-05-30
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<%
    request.setCharacterEncoding("utf-8");
    List<Booking> list=(List<Booking>)request.getAttribute("allInfor");
    Booking booking=new Booking();


%>
<link rel="stylesheet" href="css/patient.css">
<body>
<h3>当前位置：预约管理</h3>
<hr>
<jsp:include page="header_booking.jsp"></jsp:include>
<table class="table table-hover text-center">
    <tbody><tr>
        <th width="10%">单号</th>
        <th width="10%">医生ID</th>
        <th width="10%">挂号类型</th>
        <th width="10%">患者类型</th>
        <th width="10%">时间</th>
        <th width="10%">挂号费用</th>
        <th width="10%">完成标志</th>
    </tr>
    <%
        if(list!=null){
            for(int i=0;i<list.size();i++){


    %>
    <tr>
        <td><%=list.get(i).getId()%></td>
        <td><%=list.get(i).getDoctorId() %></td>
        <td><%=list.get(i).getListId()%></td>
        <td><%=list.get(i).getType() %></td>
        <td><%=list.get(i).getpTime() %></td>
        <td><%=list.get(i).getCosts() %></td>
        <td><%=list.get(i).getSign() %></td>
            <%  }
			} %>

    </tbody></table>
<!--分页-->

<jsp:include page="footer_style.jsp"></jsp:include>
</body>
</html>


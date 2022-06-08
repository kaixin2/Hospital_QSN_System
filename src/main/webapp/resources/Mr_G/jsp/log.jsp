<%@ page import="com.example.Mr_G.model.Log" %>
<%@ page import="java.util.List" %><%--
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
<%
    request.setCharacterEncoding("utf-8");
    List<Log> list=(List<Log>)request.getAttribute("allInfor");

%>
<table class="table table-hover text-center">
    <tbody><tr>
        <th width="10%">编号</th>
        <th width="10%">医生ID</th>

        <th width="10%">患者ID</th>

        <th width="10%">挂号单号</th>
        <th width="10%">取药单号</th>
        <th width="10%">费用单号</th>


    </tr>
    <%
        if(list!=null){
            for(int i=0;i<list.size();i++){
    %>
    <tr>
        <td><%=list.get(i).getID()%></td>
        <td><%=list.get(i).getDoctorID() %></td>
        <td><%=list.get(i).getPatientID()%></td>
        <td><%=list.get(i).getBookingID() %></td>
        <td><%=list.get(i).getMedicineID() %></td>
        <td><%=list.get(i).getCostID() %></td>
            <%  }
			} %>
    </tbody></table>
<!--分页-->
<jsp:include page="footer_style.jsp"></jsp:include>
</body>
</html>


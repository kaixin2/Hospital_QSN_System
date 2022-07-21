<%@ page import="java.util.List" %>
<%@ page import="com.example.Mr_G.model.Patient" %>
<%@ page import="com.example.Mr_G.controller.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>

<link rel="stylesheet" href="css/patient.css">
<body>
<%
    request.setCharacterEncoding("utf-8");
    List <Patient> list=(List<Patient>)request.getAttribute("allInfor");

%>
<h3 >当前位置：普通用户管理</h3>
<hr>
<jsp:include page="header_user.jsp"></jsp:include>
<div id="patientIndex">
    <table class="table table-hover text-center">
        <tbody><tr>
            <th width="10%">ID</th>
            <th width="10%">姓名</th>
            <th width="10%">性別</th>
            <th width="10%">联系方式</th>
            <th width="10%">地址</th>
            <th width="10%">身份证号</th>

        </tr>
        <%
            if(list!=null){
                for(int i=0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getId()%></td>
            <td><%=list.get(i).getName() %></td>
            <td><%=list.get(i).getSex()%></td>
            <td><%=list.get(i).getTelephone() %></td>
            <td><%=list.get(i).getAddress() %></td>
            <td><%=list.get(i).getIdno() %></td>
                <%  }
			} %>

        </tbody></table>

    <!--分页-->
    <jsp:include page="footer_style.jsp"></jsp:include>
</div>

</body>
</html>


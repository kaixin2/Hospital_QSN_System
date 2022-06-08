
<%@ page import="java.util.List" %>
<%@ page import="com.example.Mr_L.model.Doctor" %><%--
  Created by IntelliJ IDEA.
  User: kawhi leonard
  Date: 2022-05-31
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Doctor>list1=(List<Doctor>)request.getAttribute("list1");%>
<html>
<head>
    <title></title>

</head>
<link rel="stylesheet" type="text/css" href="resources/Mr_L/css/hospital.css">
<script type="text/javascript" src="resources/Mr_L/regist.js"></script>
<body>
<div>
    <div class="doctor" style="float:left;"><img src="resources/Mr_L/img/www.png" ></div>
    <div>
        <table>
            <tr>
                <th >姓名</th>
                <th >工号</th>
                <th >工作时间</th>
                <th>科室</th>
                <th>诊室</th>
            </tr>
            <tr>
                <th > <%=list1.get(0).getName()%></th>
                <th ><%= list1.get(0).getId()%></th>
                <th id="time"><%=list1.get(0).getTime()%></th>
                <th><%=list1.get(0).getCourses()%></th>
                <th><%=list1.get(0).getRoom()%></th>
            </tr>
        </table>
    </div>
</div>
<input type="button" value="下班" onclick="f2()">


</body>
</html>

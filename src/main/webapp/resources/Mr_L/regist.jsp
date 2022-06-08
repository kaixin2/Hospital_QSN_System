
<%@ page import="java.util.List" %>
<%@ page import="com.example.Mr_L.model.Regist" %><%--
  Created by IntelliJ IDEA.
  User: kawhi leonard
  Date: 2022-05-31
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Regist>list2=(List<Regist>)request.getAttribute("list2"); %>
<html>
<head>
    <title></title>
</head>
<link rel="stylesheet" type="text/css" href="resources/Mr_L/css/hospital.css">
<script type="text/javascript" src="resources/Mr_L/regist.js"></script>

<body>

<input type="button" value="暂停" id="pause" onclick="f1()">

<div class="regist-out">
<table class="regist" id="mytable" align="center" border="1px" cellspacing="1px" cellpadding="1px" class="table">
  <tr ><th colspan="3">挂号队列</th></tr>
  <tr>
    <th class="th">单号</th>
    <th class="th">医生工号</th>
    <th class="th">优先级</th>
  </tr>
<% for (Regist regist : list2) {

%>
  <tr>
    <td><%=regist.getId()%>
    </td>
    <td><%=regist.getDoctorid()%>
    </td>
    <td><%=regist.getType()%>
    </td>
  </tr>
  <%}%>
</table>

</div>

<div class="operate">
  <form action="PassServlet" method="post" onsubmit="return f3()">
    单号：<input type="text" name="idname1" id="call">
  <input type="submit" value="叫号"  />
  </form>

  <form action="PassServlet" method="post" onsubmit="return f4()">
    单号：<input type="text" name="idname" id="regist">
  <input type="submit" value="过号" />
  </form>
  <% String s="在叫号后点击该按钮，若患者已经签到则刷新挂号队列";%>
  <a href="/Hospital_QSN_System_war_exploded/RegistServlet" style="text-decoration: none " title=<%=s%>>检查</a>
</div>

</body>
</html>

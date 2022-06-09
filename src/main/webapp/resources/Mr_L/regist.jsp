
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
<div style="margin-left: 70px">
<div style="float:left;">单号</div><div style="float:left;margin-left:50px;">医生工号</div><div style="float:left;margin-left:50px;">优先级</div>
</div>

<% for (Regist regist : list2) {
%>
<div style="margin-top: 30px;margin-left: 60px">
<div style="float:left;"><%=regist.getId()%></div>
<div style="float:left;margin-left:35px;"><%=regist.getDoctorid()%></div>
<div style="float:left;margin-left:70px;"><%=regist.getType()%></div>
</div>
<br>
<%}%>


<div class="operate" style="margin-top: 50px">
  <form action="CallServlet" method="post" onsubmit="return f3()">
    单号：<input type="text" name="idname1" id="call">
  <input type="submit" value="叫号"  />
    <span id="callForm_error"></span>
  </form>

  <form action="PassServlet" method="post" onsubmit="return f4()">
    单号：<input type="text" name="idname2" id="regist">
  <input type="submit" value="过号" />
    <span id="registForm_error"></span>
  </form>
  <% String s="在叫号后点击该按钮，若患者已经签到则刷新挂号队列";%>
  <a href="/Hospital_QSN_System_war_exploded/JudgeServlet" style="text-decoration: none " title=<%=s%>>检查</a>
</div>

</body>
</html>

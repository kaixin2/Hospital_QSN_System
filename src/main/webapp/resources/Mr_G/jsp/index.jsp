<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-05-26
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


  <title>网站后台模板</title>

</head>
<link rel="stylesheet" href="css/index.css">
<body>

<!--顶部信息区-->
<header role="header">

  <div>
      <div class="head-left"><img src="img/hospital2.png"><h1>Hospital QSN System</h1></div>

  </div>
    <nav role="user">
      <ul>
        <li>欢迎管理员</li>
        <li><a href="modify_pass.html" target="main">修改密码</a></li>
        <li><a href="javascript:void(0);" onclick="logout()">退出登录</a></li>
      </ul>
    </nav>
  </div>
</header>
<!--圣杯二列布局-->
<main role="main">
  <!--主体内联框架区-->
  <article role="content">
    <iframe src="index_style.jsp"  name="main"></iframe>
    <footer role="copyright">
      <p></p>
    </footer>
  </article>
  <!--左侧导航区-->
  <aside>
    <nav role="option">
      <ul>
        <li>导航列表</li>

        <li><a href="patient.jsp" target="main">用户管理</a></li>
        <li><a href="doctor.jsp" target="main">医生管理</a></li>
        <li><a href="booking.jsp" target="main">预约管理</a></li>
        <li><a href="bookingReport.jsp" target="main">预约报表</a></li>
        <li><a href="log.jsp" target="main">操作记录</a></li>
      </ul>
    </nav>
  </aside>
</main>
</body>
</html>


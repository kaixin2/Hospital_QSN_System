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
    List<Doctor> list=(List<Doctor>)request.getAttribute("allInfor");
    Doctor doctor = new Doctor();
%>

<table class="table table-hover text-center">
    <tbody><tr>
        <th width="10%">ID</th>
        <th width="10%">姓名</th>
        <th width="10%">医科</th>
        <th width="10%">诊室</th>
        <th width="10%">工作时间</th>
        <th width="10%">联系方式</th>
        <th width="10%"> 修改</th>
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
        <td> <a href="javascript:void(0)" onclick="displayWindowD()">修改</a></td>
            <%  }
			} %>
    </tbody></table>
<!--分页-->

<jsp:include page="footer_style.jsp"></jsp:include>
<div id="windowD" class="window_css" style="display: none">

    修改医生信息

    <hr>
    <form>
        编 号 :<input type="text" value="" id="idD"><br>
        姓 名 :<input type="text" value="" id="nameD"><br>
        医 科 :<input type="text" value="" id="typeD"><br>
        诊 室 :<input type="text" value="" id="roomD"><br>
        工作时间:<input type="text" value="" id="timeD"><br>
        联系方式:<input type="text" value="" id="phoneD"><br>
        <input type="submit" value="确定"  onclick="validateFormD()">
        <input type="submit" value="取消"  onclick="hideWindowD()">
    </form>

</div>
<!--出现悬浮窗口后,背景变暗-->
<div id="shadowD" class="shadow_css"></div>
<script type="text/javascript">
    function displayWindowD() {
        /*悬浮窗口的显示,需要将display变成block*/
        document.getElementById("windowD").style.display = "block";
        /*将背景变暗*/
        document.getElementById("shadowD").style.display = "block";
    }

    /*当点击调用此方法,将悬浮窗口和背景全部隐藏*/
    function hideWindowD() {
        document.getElementById("windowD").style.display = "none";
        document.getElementById("shadowD").style.display = "none";
    }
    function validateFormD(){

        var id=document.getElementById("idD").value;
        var name=document.getElementById("nameD").value;

        var phone=document.getElementById("phoneD").value;


        var room=document.getElementById("roomD").value;
        if(id.length!=4){
            alert("编号输入不合法")


        }
        if(name.length==0){
            alert("姓名输入不能为空")
        }


        if(room.length!=8){
            alert("诊室输入不合法")


        }
        if(phone.length!=11){
            alert("电话输入不合法")


        }

    }
</script>
</body>
</html>


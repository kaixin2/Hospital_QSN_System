<%@ page import="com.example.Mr_G.model.Doctor" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-04
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .text-input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 30px;
        padding: 13px 14px;
        width: 620px;
        font-size: 14px;
        font-weight: 700;
    }
    .button{
        border-radius: 30px;
        width: 70px;
        height: 40px;
    }
    .modiform{
        text-align:center;
    }
</style>
<%
    request.setCharacterEncoding("utf-8");
    Doctor listSear=(Doctor) request.getAttribute("SearInfor");

%>
<div >
    <form action="DoctorServlet?temp=telqurey" method="post">
        <input type="text" class="text-input" placeholder="联系电话进行查询" name="searchD1" id="searchD1" >
        <input type="submit" class="button" value="搜索" >
        <input type="button" class="button" value="新建" onclick="add1()">
    </form>
</div>



<%
    if(listSear!=null){
%>
<form class="modiform" action="DoctorServlet?temp=updatequrey" method="post">
    编 号 :<input type="text" value="<%=listSear.getID() %>" name="idD1" readonly><br>
    姓 名 :<input type="text" value="<%=listSear.getName() %>" name="nameD1"><br>
    医 科 :<input type="text" value="<%=listSear.getCourse() %>" name="typeD1"><br>
    诊 室 :<input type="text" value="<%=listSear.getRoom() %>" name="roomD1"><br>
    工作时间:<input type="text" value="<%=listSear.getTime() %>" name="timeD1"><br>
    联系方式:<input type="text" value="<%=listSear.getTelephone() %>" name="phoneD1"><br>
    <input type="submit" value="修改" >
    <%
        }
    %>
</form>



<div id="windowD1" class="window_css" style="display:none">
    新增医生信息
    <hr>
    <form  class="modiform" action="DoctorServlet?temp=addqurey" method="post">
        编 号 :<input type="text" value="" name="idD1"><br>
        姓 名 :<input type="text" value="" name="nameD1"><br>
        医 科 :<input type="text" value="" name="typeD1"><br>
        诊 室 :<input type="text" value="" name="roomD1"><br>
        工作时间:<input type="text" value="" name="timeD1"><br>
        联系方式:<input type="text" value="" name="phoneD1"><br>
        <input type="submit" value="确定"  onclick="validateFormD1()">
    </form>
</div>



<!--出现悬浮窗口后,背景变暗-->
<div id="shadowD1" class="shadow_css"></div>
<br>
<script>

    function add1(){

        /*悬浮窗口的显示,需要将display变成block*/
        document.getElementById("windowD1").style.display = "block";
        /*将背景变暗*/
        document.getElementById("shadowD1").style.display = "block";


    }
    function hideWindow1() {
        document.getElementById("windowD1").style.display = "none";
        document.getElementById("shadowD1").style.display = "none";
    }

</script>

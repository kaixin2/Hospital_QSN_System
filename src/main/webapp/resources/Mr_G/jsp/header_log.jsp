<%@ page import="com.example.Mr_G.model.Log" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-03
  Time: 12:20
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
<div>
    <%
        request.setCharacterEncoding("utf-8");
        Log listSear=(Log) request.getAttribute("SearInfor");

    %>
    <form action="LogServlet?temp=idqurey" method="post">
        <input type="text" class="text-input" placeholder="请输入医生id/患者id进行查询"  value="" name="searchL1" id="searchL1">
        <input type="submit" class="button" value="搜索" onclick="valid()">
    </form>

</div>

<br>
<%
    if(listSear!=null){

%>

<form class="modiform">
    编号 :<input type="text" value="<%=listSear.getID() %>"><br>
    医 生 ID :<input type="text" value="<%=listSear.getDoctorID() %>" ><br>
    患 者 ID :<input type="text" value="<%=listSear.getPatientID() %>" ><br>
    挂 号 单 号 :<input type="text" value="<%=listSear.getBookingID() %>"><br>
    取 药 单 号 :<input type="text" value="<%=listSear.getMedicineID()%>" ><br>
    费 用 单 号 :<input type="text" value="<%=listSear.getCostID() %>" ><br>
</form>
<%}
%>
<script>
    function valid(){

        var sear=document.getElementById("searchL1").value;
        if(sear.length!=4){
            alert("输入不合法")
        }
        return false;
    }

</script>


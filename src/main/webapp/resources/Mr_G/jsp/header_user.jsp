<%@ page import="com.example.Mr_G.model.Patient" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-02
  Time: 8:55
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
    Patient listSear=(Patient) request.getAttribute("SearInfor");

%>
<div >

    <form action="PatientServlet?temp=telqurey" method="post">

        <input type="text" class="text-input" placeholder="联系电话进行查询" name="searchP1" id="searchP1" >
        <input type="submit" class="button" value="搜索" onclick="validateForm1()">
        <input type="button" class="button" value="新建" onclick="add()">

    </form>

</div>

<%
    if(listSear!=null){

%>

<form class="modiform" action="PatientServlet?temp=updatequrey" method="post">
    编 号 :<input type="text" value="<%=listSear.getId()%>" name="id1"><br>
    姓 名 :<input type="text" value="<%=listSear.getName() %>" name="name1"><br>
    性 别 :<input type="text" value="<%=listSear.getSex()%>" name="sex1"><br>
    电 话 :<input type="text" value="<%=listSear.getTelephone() %>" name="phone1"><br>
    地 址 :<input type="text" value="<%=listSear.getAddress() %>" name="address1"><br>
    身份证号:<input type="text" value=" <%=listSear.getIdno() %>" name="idno1"><br>
    <input type="submit" value="修改"  >
</form>

<%}

%>

<div id="window" class="window_css" style="display:none">

    新增用户信息

    <hr>
    <form class="modiform" action="PatientServlet?temp=addqurey" method="post">
        编 号 :<input type="text" value="" name="id"><br>
        姓 名 :<input type="text" value="" name="name"><br>
        性 别 :<input type="text" value="" name="sex"><br>
        电 话 :<input type="text" value="" name="phone"><br>
        地 址 :<input type="text" value="" name="address"><br>
        身份证号:<input type="text" value="" name="idno"><br>
        <input type="submit" value="确定" onclick="validateForm()">

    </form>

</div>
<!--出现悬浮窗口后,背景变暗-->
<div id="shadow" class="shadow_css"></div>
<br>
<script>
    function validateForm1(){

        var sear=document.getElementById("searchP1").value;
        if(sear.length!=11){
            alert("电话输入不合法")

        }
        return false;
    }
    function add(){

        /*悬浮窗口的显示,需要将display变成block*/
        document.getElementById("window").style.display = "block";
        /*将背景变暗*/
        document.getElementById("shadow").style.display = "block";
    }
    function hideWindow() {
        document.getElementById("window").style.display = "none";
        document.getElementById("shadow").style.display = "none";
    }

</script>

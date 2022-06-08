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
    Patient patient = new Patient();
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
            <th width="10%">修改</th>
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
            <td> <a href="javascript:void(0)" onclick="displayWindow1()">修改</a></td>
                <%  }
			} %>

        </tbody></table>

    <!--分页-->
    <jsp:include page="footer_style.jsp"></jsp:include>
</div>

<div id="window1" class="window_css" style="display: none">

    修改用户信息

    <hr>
    <form >
        编 号 :<input type="text" value="" id="id1"><br>
        姓 名 :<input type="text" value="" id="name1"><br>
        性 别 :<input type="text" value="" id="sex1"><br>
        电 话 :<input type="text" value="" id="phone1"><br>
        地 址 :<input type="text" value="" id="address1"><br>
        身份证号:<input type="text" value="" id="idno1"><br>
        <input type="submit" value="确定"  onclick="validateForm1()">
        <input type="submit" value="取消"  onclick="hideWindow1()">
    </form>

</div>
<!--出现悬浮窗口后,背景变暗-->
<div id="shadow1" class="shadow_css"></div>
<script type="text/javascript" >

    function displayWindow1() {
        alert("1");
        /*悬浮窗口的显示,需要将display变成block*/
        document.getElementById("window1").style.display = "block";
        /*将背景变暗*/
        document.getElementById("shadow1").style.display = "block";


    }

    /*当点击调用此方法,将悬浮窗口和背景全部隐藏*/
    function hideWindow1() {
        alert("1");
        document.getElementById("window1").style.display = "none";
        document.getElementById("shadow1").style.display = "none";
    }
    function validateForm1(){

        var id=document.getElementById("id1").value;
        alert(id.length);
        var name=document.getElementById("name1").value;

        var sex=document.getElementById("sex1").value;

        var phone=document.getElementById("phone1").value;

        var idno=document.getElementById("idno1").value;


        if(id.length!=4){
            alert("编号输入不合法")

        }

        if(name.length==0){
            alert("姓名输入不能为空")
        }
        if(sex!='男'&&sex!='女'){
            alert("性别输入不合法")

        }
        if(phone.length!=11){
            alert("电话输入不合法")


        }
        if(idno.length!=18){
            alert("身份证输入不合法")

        }


    }


</script>

</body>
</html>


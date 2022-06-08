<%@ page import="com.example.Mr_G.model.Booking" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-03
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .text-input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 30px;
        height: 38px;
        width: 55%;
        font-size: 14px;
        font-weight: 700;
        float: left;

    }

    .text-startTime{
        width: 15%;
    }
    .text-endTime{
        width: 15%;
    }
    .button1{
        border-radius: 25px;
        width: 70px;
        height: 38px;
    }
    .button2{
        width: 10%;
    }
    select{
        width: 50%;
        height:30px;
    }
    .modiform{
        text-align:center;
    }
    table, th, td {
        border: solid 1px #efefef;
    }
    table {
        width: 100%;
        margin: auto;
        border-collapse: collapse;
        text-align: center;
        border-radius: 6px;
    }
    td,th{
        padding: 10px;
    }
</style>
<%
    request.setCharacterEncoding("utf-8");
    Booking listSear=(Booking) request.getAttribute("IdInfor");

    List<Booking> listTime=(List<Booking>)request.getAttribute("TimeInfor");

%>
<div>
    <form action="#">
        请选择搜索方式：
        <select  class="choice" name="" id="choice" onchange="changeForm()" >
            <option value="" >请选择</option>
            <option value="1" >医生id</option>
            <option value="2" >时间</option>

        </select>

    </form>

    <br>

    <div class="type" id="doctorId" style="display: none;">
        <form action="BookingServlet?temp=idqurey" method="post">
            <input type="text" class="text-input" placeholder="请输入医生id进行查询" value="" id="BDid" name="searchB">
            <input type="submit" class="button1" value="搜索" onclick="validdateFormBD()">
        </form>
    </div>
    <%
        if(listSear!=null){
    %>

    <form class="modiform">
        单 号 :<input type="text" value="<%=listSear.getId()%>"><br>
        医 生 I  D  :<input type="text" value="<%=listSear.getDoctorId() %>" ><br>
        挂 号 类 型 :<input type="text" value="<%=listSear.getListId()%>" ><br>
        患 者 类 型 :<input type="text" value="<%=listSear.getType() %>" ><br>
        挂 号 时 间 :<input type="text" value="<%=listSear.getpTime()%>" ><br>
        挂 号 费 用 :<input type="text" value=" <%=listSear.getCosts() %>" ><br>
        挂 号 标 志 :<input type="text" value=" <%=listSear.getSign() %>" ><br>
    </form>
    <%}
    %>

    <div class="type" id="Time" style="display: none;">
        <form action="BookingServlet?temp=timequrey" method="post">

            开始时间：<input type="date" id="time1" value="" name="searchT1"/>
            结束时间：<input type="date"  id="time2" value="" name="searchT2"/>
            <input type="submit" value="搜索" onclick="validdateFormBT()">

        </form>
    </div>

    <%
        if(listTime!=null){
    %>
    <table class="table table-hover text-center" >
        <tbody><tr>
            <th width="10%">单号</th>
            <th width="10%">医生ID</th>
            <th width="10%">挂号类型</th>
            <th width="10%">患者类型</th>
            <th width="10%">时间</th>
            <th width="10%">挂号费用</th>
            <th width="10%">完成标志</th>
        </tr>
        <%
            for(int i=0;i<listTime.size();i++){
        %>
        <tr>
            <td><%=listTime.get(i).getId()%></td>
            <td><%=listTime.get(i).getDoctorId() %></td>
            <td><%=listTime.get(i).getListId()%></td>
            <td><%=listTime.get(i).getType() %></td>
            <td><%=listTime.get(i).getpTime() %></td>
            <td><%=listTime.get(i).getCosts() %></td>
            <td><%=listTime.get(i).getSign() %></td>
        </tr>
        <%  }
        } %>

        </tbody>
    </table>
</div>
<br>
<script>

    function changeForm(){
        var choice = document.getElementById("choice").value;

        var doc=document.querySelector("#doctorId");

        var time=document.querySelector("#Time");
        if(choice=="1"){
            doc.style.display="block"
            time.style.display="none"

        }
        else if(choice="2"){
            doc.style.display="none"
            time.style.display="block"
        }
        else{
            doc.style.display="none"
            time.style.display="none"
        }
    }
    function validdateFormBD(){

        var id=document.getElementById("BDid").value;
        if(id.length!=4)
            alert("id输入不合法");

        return false;
    }
    function validdateFormBT(){

        var time1=document.getElementById("time1").value;
        var time2=document.getElementById("time2").value;
        if(time1==""||time2=="")
            alert("请选择时间");
        return false;
    }

</script>
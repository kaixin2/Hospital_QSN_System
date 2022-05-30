<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-29
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Mr_W.model.doctor,java.util.*" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" language=javascript src="laydate.js"></script>
<%
    doctor doctor1=new doctor();
    doctor doctor4=new doctor();
    doctor1.setId("00000001");
    doctor4.setId("00000004");

    doctor1.setCourses("神经科");
    doctor4.setCourses("内科");
    doctor1.setName("张三");
    doctor4.setName("刘六");
    List<doctor> list=new ArrayList<>();
    list.add(doctor1);
    list.add(doctor4);
    request.setAttribute("doctor",list);
    request.setAttribute("doctors",list);
%>
<jsp:include page="inc/header.inc"></jsp:include>
<style type="text/css">
    .laydate-time-list{padding-bottom:0;overflow:hidden}
    .laydate-time-list>li{width:50%!important;}
    .laydate-time-list>li:last-child { display: none;}
</style>
<script>

    laydate.render({
        elem: '#test1',
        trigger: "click",
        type: 'date',
        min:getNowFormatDate(),
        format: 'yyyy-MM-dd',
    });
    laydate.render({
        elem: '#test2',
        trigger: "click",
        type: 'time',
        format:'HH:mm',
    });
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        return date.getFullYear() + seperator1 + month
            + seperator1 + strDate + " " + date.getHours() + seperator2
            + date.getMinutes() + seperator2 + date.getSeconds();
    }
</script>
<div class="content" style="width:780px; height: 730px">
    <form action="addDoctor.jsp" style="padding-left:400px;width: 780px; font-size: 25px">
            <div style="font-size: 30px;font-weight: bolder;padding-left: 150px">挂号</div><br>
        挂号类型：<input type="radio" name="type1" value="1">就诊
        <input type="radio" name="type1" value="2">预约
        <input type="radio" name="type1" value="3">取药<br>
        患者类型：<input type="radio" name="type2" value="1">普通
        <input type="radio" name="type2" value="2">急诊<br>
        选择时间：<br>
        日期：<input type="text" name="date" id="test1" readonly="readonly">
        时间：<input type="text" name="time" id="test2" readonly="readonly"><br>
        选择科室：<br>
        <select name="searchType" id="searchType">
            <option value="0" selected>请选择查询条件</option>
            <%
                for(doctor doctor:list){
            %>
            <option value="<%=doctor.getCourses()%>"><%=doctor.getCourses()%></option>
            <%}%>
        </select><br>
        <input type="submit" value="选择医生" style="align-content: center"><br>
    </form>
</div>
<jsp:include page="inc/footer.inc"></jsp:include>

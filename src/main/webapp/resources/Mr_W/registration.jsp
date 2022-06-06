<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-29
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.example.Mr_W.model.doctor,java.util.*" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" language=javascript src="resources/Mr_W/laydate.js"></script>
<script type="text/javascript" language=javascript src="resources/Mr_W/registration.js"></script>

<jsp:include page="inc/header.inc"></jsp:include>

<div class="content" style="width:780px; height: 730px">
    <form action="addDoctors" style="padding-top:100px;padding-left:400px;width: 780px; font-size: 25px" onsubmit="return registrationValidate()">
            <div style="font-size: 30px;font-weight: bolder;padding-left: 150px">挂号</div><br>
        挂号类型：<input type="radio" name="type1" value="1" checked="checked">就诊
        <input type="radio" name="type1" value="2">取药|取药单号：<input type="text" name="listId"><br>
        患者类型：<input type="radio" name="type2" value="1" checked="checked">普通
        <input type="radio" name="type2" value="2">急诊<br>
        选择时间：<br>
        日期：<input type="text" class="date" name="date" id="test1" readonly="readonly">
        时间：<input type="text" class="time" name="time" id="test2" readonly="readonly"><br>
        选择科室：<br>
        <select name="searchType" id="searchType">
            <option value="0" selected>请选择查询条件</option>
            
            <c:forEach var="doctor" items="${doctor}" varStatus="var">
            	<option value="<c:out value="${doctor.courses}"/>"><c:out value="${doctor.courses}"/></option>
            </c:forEach>
            
        </select><br>
        <span id="id" class="error"></span><br>
        <input type="submit" value="选择医生" style="align-content: center"><br>
    </form>
</div>
<jsp:include page="inc/footer.inc"></jsp:include>

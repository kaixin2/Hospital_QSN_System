<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-29
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" language=javascript src="Mr_W/registration.js"></script>
<jsp:include page="inc/header.inc"></jsp:include>
<div class="content">
    <table class="table" border="1" cellspacing="0">
        <tr style="font-size: 25px">
            <th colspan="10">挂号单</th>
        </tr>
        <tr style="font-size: 15px">
            <th>ID</th>
            <th>挂号类型</th>
            <th>患者类型</th>
            <th>医生名字</th>
            <th>科室</th>
            <th>诊室</th>
            <th>时间</th>
            <th>挂号金额</th>
            <th>是否完成</th>
            <th>操作</th>
        </tr>
        <jsp:useBean id="registrationInfor" scope="request" type="java.util.List<com.example.Mr_W.model.registration>"/>
        <c:forEach var="registration" items="${registrationInfor}" varStatus="var">
        	<tr style="font-size: 15px">
            	<td><c:out value="${registration.id}"/></td>
            	<td><c:out value="${registration.listID}"/></td>
            	<td><c:out value="${registration.pType}"/></td>
            	<th><c:out value="${registration.doctor.name}"/></th>
                <th><c:out value="${registration.doctor.courses}"/></th>
                <th><c:out value="${registration.doctor.room}"/></th>
            	<th><c:out value="${registration.pTime}"/></th>
            	<td><c:out value="${registration.costs}"/></td>
            	<td><c:out value="${registration.sign}"/></td>
                <c:if test="${registration.sign=='已完成'}">
                    <td>无</td>
                </c:if>
                <c:if test="${registration.sign=='未完成'}">
            	<td><input type="button" value="取消" onclick="revocation('<c:out value="${registration.id}"/>')"></td>
                </c:if>
        	</tr>
        </c:forEach>
    </table>
    <form style="margin-left:400px; font-size: 25px">
    当前人数：<jsp:useBean id="sum" scope="request" type="java.lang.Integer"/>
    <c:out value="${sum}"/>
    是否叫到：<jsp:useBean id="queue" scope="request" type="java.lang.String"/>
    <c:out value="${queue}"/><br>
    <input type="button" onclick="check()" value="检查">
    <input type="submit" value="签到">
    </form>
</div>
<jsp:include page="inc/footer.inc"></jsp:include>

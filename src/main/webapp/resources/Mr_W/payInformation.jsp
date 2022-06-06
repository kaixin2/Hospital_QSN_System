<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-29
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" language=javascript src="resources/Mr_W/registration.js"></script>
<jsp:include page="inc/header.inc"></jsp:include>
<div class="content">

    <table class="table" border="1" cellspacing="0" align="center">
        <tr style="font-size: 25px">
            <th colspan="6">费用记录</th>
        </tr>
        <tr style="font-size: 15px">
            <th>ID</th>
            <th>目的</th>
            <th>支付单号</th>
            <th>金额/元</th>
            <th>是否支付</th>
            <th>选择</th>
        </tr>
  		<jsp:useBean id="expense" scope="request" type="java.util.List<com.example.Mr_W.model.expense>"/>
  		<c:forEach var="expense" items="${expense}" varStatus="var">
        	<tr>
            	<td><c:out value="${expense.id}"/></td>
            	<td><c:out value="${expense.goal}"/></td>
            	<td><c:out value="${expense.payID}"/></td>
            	<td><c:out value="${expense.cost}"/></td>
            	<th><c:out value="${expense.sign}"/></th>
            	<th><input type="button" value="&#x270e;" onclick="copy('<c:out value="${expense.payID}"/>','<c:out value="${expense.goal}"/>')"></th>
        	</tr>
       </c:forEach>
        
    </table>
    <form action="pay" style="margin-left:400px;width: 780px; font-size: 25px" onsubmit="return reCheck()">
		<jsp:useBean id="payId" scope="request" class="java.lang.String"/>
        <input type="hidden" name="id" value="<c:out value="${payId}"/> ">
		<input type="submit" class="botton" value="支付">
		<jsp:useBean id="error" scope="request" class="java.lang.String"/>
        <span id="information" class="error">
		<c:if test="${not empty error}">
			已支付或者已取消
		</c:if>
		</span>
    </form>

    <c:if test="${param.id=='1'}">
	<table class="table" border="1" cellspacing="0" align="center">
	<tr>
		<th>ID</th>
		<th>医生名字</th>
		<th>医科</th>
		<th>诊室</th>
		<th>费用</th>
	</tr>
	<tr>
		<td><c:out value="${expenseDetail.id}"/></td>
		<td><c:out value="${expenseDetail.doctor.name}"/></td>
		<td><c:out value="${expenseDetail.doctor.courses}"/></td>
		<td><c:out value="${expenseDetail.doctor.room}"/></td>
		<td><c:out value="${expenseDetail.costs}"/></td>
	</tr>
	</table>
	</c:if>
	
	<c:if test="${param.id=='2'}">
	<table class="table" border="1" cellspacing="0" align="center">
	<tr>
		<th>ID</th>
		<th>药名</th>
		<th>数量</th>
		<th>费用</th>
	</tr>
	<tr>
		<td><c:out value="${expenseDetail.id}"/></td>
		<td><c:out value="${expenseDetail.drug.name}"/></td>
		<td><c:out value="${expenseDetail.num}"/></td>	
		<td><c:out value="${expenseDetail.cost}"/></td>	
	</tr>
	</table>
	</c:if>
</div>
<jsp:include page="inc/footer.inc"></jsp:include>
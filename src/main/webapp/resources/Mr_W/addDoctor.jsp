<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-30
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="inc/header.inc"></jsp:include>
<jsp:useBean id="doctorList" scope="request" type="java.util.List<com.example.Mr_W.model.doctor>"/>
<div class="content">
<table border="1" cellspacing="0" style="margin-left:400px;width: 780px; font-size: 25px">
    <tr>
        <th colspan="2"><c:out value="${doctorList.get(0).courses}"/></th>
    </tr>
    <tr>
        <td>ID</td>
        <td>名字</td>
    </tr>

    <c:forEach var="doctorList" items="${doctorList}" varStatus="var">
    <tr>
        <td><c:out value="${doctorList.id}"/></td>
        <td><c:out value="${doctorList.name}"/></td>
    </tr>
    </c:forEach>
</table>
    <form style="margin-left:400px;width: 780px; font-size: 25px">
        填写医生id：<br>
        <input type="text" name="doctor"><span id="doctor_error" class="error"></span><br>
        <input type="submit" value="提交"><br>
    </form>
</div>
<script>
    var frm=document.querySelector('form');
    frm.onsubmit = function(){
        var input_account=document.getElementsByName('doctor')[0];
        if(/^\d{3}$/.test(input_account.value))
            return true;
        else{
            document.getElementById('doctor_error').innerText='format error...';
            return false;
        }
    }
</script>
<jsp:include page="inc/footer.inc"></jsp:include>
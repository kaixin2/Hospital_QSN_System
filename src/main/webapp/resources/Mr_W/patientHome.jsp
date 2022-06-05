<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-28
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="inc/header.inc"></jsp:include>
    <div class="content">
        <div class="content-top">
            <jsp:useBean id="login" scope="request" class="com.example.Mr_W.model.patient"/>
            <p>ID：<c:out value="${login.id}"/> </p><br>
            <p>名字：<c:out value="${login.name}"/></p><br>
            <p>性别：<c:out value="${login.sex}"/></p><br>
            <p>地址：<c:out value="${login.address}"/></p><br>
            <p>电话：<c:out value="${login.telephone}"/></p><br>
        </div>
        <div class="content-content"></div>
        <div class="content-table"></div>
    </div>
<jsp:include page="inc/footer.inc"></jsp:include>

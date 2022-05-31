<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-29
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="inc/header.inc"></jsp:include>
<div class="content">
    <table border="1" cellspacing="0" style="margin-left:400px;width: 780px;">
        <tr style="font-size: 25px">
            <th colspan="7">挂号单</th>
        </tr>
        <tr style="font-size: 15px">
            <th>ID</th>
            <th>挂号类型</th>
            <th>患者类型</th>
            <th>医生名字</th>
            <th>时间</th>
            <th>挂号金额</th>
            <th>是否完成</th>
        </tr>
        <tr style="font-size: 15px">
            <td>000001</td>
            <td>就诊</td>
            <td>普通</td>
            <th>王五</th>
            <th>2022-5-31</th>
            <td>10</td>
            <td>未完成</td>
        </tr>
        <tr style="font-size: 15px">
            <td>010002</td>
            <td>就诊</td>
            <td>急诊</td>
            <th>王五</th>
            <th>2022-5-29</th>
            <td>10</td>
            <td>已完成</td>
        </tr>
    </table>
</div>
<jsp:include page="inc/footer.inc"></jsp:include>

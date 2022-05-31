<%--
  Created by IntelliJ IDEA.
  User: 艾狸
  Date: 2022-05-29
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="inc/header.inc"></jsp:include>
<div class="content">
    <table border="1" cellspacing="0" style="margin-left:400px;width: 780px;">
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
        <tr>
            <td>001</td>
            <td>就诊</td>
            <td>00001</td>
            <td>30</td>
            <th>未支付</th>
            <th><input type="button" value="&#x270e;" onclick="copy('001')"></th>
        </tr>
        <tr>
            <td>002</td>
            <td>取药</td>
            <td>30002</td>
            <td>100</td>
            <th>已支付</th>
            <th><input type="button" value="&#x270e;" onclick="copy('002')"></th>
        </tr>
    </table>
    <form style="margin-left:400px;width: 780px; font-size: 25px">
        费用单：<input type="text" id="pay" readonly="true"><br>
        <input type="submit" value="支付">
    </form>
</div>
<script>
    function copy(id){
        document.getElementById('pay').value=id;
    }
</script>
<jsp:include page="inc/footer.inc"></jsp:include>
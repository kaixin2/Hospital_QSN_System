<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-03
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .text-input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 30px;
        padding: 13px 14px;
        width: 620px;
        font-size: 14px;
        font-weight: 700;
    }
    .button{
        border-radius: 30px;
        width: 70px;
        height: 40px;
    }
</style>
<div>

    <form>

        <input type="text" class="text-input" placeholder="请输入医生id/患者id进行查询" id="Logid" value="">
        <input type="submit" class="button" value="搜索" onclick="validdateFormLog()">

    </form>

</div>
<br>
<script>
    function validdateFormLog(){
        alert("!");
        var id=document.getElementById("Logid").value;
        if(id.length!=4)
            alert("id输入不合法");
    }
</script>

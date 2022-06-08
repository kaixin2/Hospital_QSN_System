<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-04
  Time: 15:16
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
<div >

    <form>

        <input type="text" class="text-input" placeholder="输入姓名/联系电话进行查询">
        <input type="submit" class="button" value="搜索" >
        <input type="button" class="button" value="新建" onclick="add1()">
    </form>

</div>
<div id="windowD1" class="window_css" style="display: none">

    新增医生信息

    <hr>
    <form>
        编 号 :<input type="text" value="" id="idD1"><br>
        姓 名 :<input type="text" value="" id="nameD1"><br>
        医 科 :<input type="text" value="" id="typeD1"><br>
        诊 室 :<input type="text" value="" id="roomD1"><br>
        工作时间:<input type="text" value="" id="timeD1"><br>
        联系方式:<input type="text" value="" id="phoneD1"><br>
        <input type="submit" value="确定"  onclick="validateFormD1()">
        <input type="submit" value="取消"  onclick="hideWindowD1()()">
    </form>

</div>
<!--出现悬浮窗口后,背景变暗-->
<div id="shadowD1" class="shadow_css"></div>
<br>
<script>
    function add1(){

        /*悬浮窗口的显示,需要将display变成block*/
        document.getElementById("windowD1").style.display = "block";
        /*将背景变暗*/
        document.getElementById("shadowD1").style.display = "block";


    }
    function hideWindow1() {
        document.getElementById("windowD1").style.display = "none";
        document.getElementById("shadowD1").style.display = "none";
    }
    function validateFormD1(){

        var id=document.getElementById("idD1").value;
        var name=document.getElementById("nameD1").value;

        var phone=document.getElementById("phoneD1").value;

        var room=document.getElementById("roomD1").value;
        if(id.length!=4){
            alert("编号输入不合法")


        }
        if(name.length==0){
            alert("姓名输入不能为空")
        }
        if(phone.length!=11){
            alert("电话输入不合法")


        }

        if(room.length!=8){
            alert("诊室输入不合法")


        }
    }
</script>

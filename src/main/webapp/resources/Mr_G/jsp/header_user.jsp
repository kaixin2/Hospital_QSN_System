<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-02
  Time: 8:55
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
        <input type="button" class="button" value="新建" onclick="add()">
    </form>

</div>
<div id="window" class="window_css" style="display: none">

    新增用户信息

    <hr>
    <form>
        编 号 :<input type="text" value="" id="id"><br>
        姓 名 :<input type="text" value="" id="name"><br>
        性 别 :<input type="text" value="" id="sex"><br>
        电 话 :<input type="text" value="" id="phone"><br>
        地 址 :<input type="text" value="" id="address"><br>
        身份证号:<input type="text" value="" id="idno"><br>
        <input type="submit" value="确定"  onclick="validateForm()">
        <input type="submit" value="取消"  onclick="hideWindow()">
    </form>

</div>
<!--出现悬浮窗口后,背景变暗-->
<div id="shadow" class="shadow_css"></div>
<br>
<script>
    function add(){

        /*悬浮窗口的显示,需要将display变成block*/
        document.getElementById("window").style.display = "block";
        /*将背景变暗*/
        document.getElementById("shadow").style.display = "block";


    }
    function hideWindow() {
        document.getElementById("window").style.display = "none";
        document.getElementById("shadow").style.display = "none";
    }
    function validateForm(){

        var id=document.getElementById("id").value;
        alert(id.length);
        var name=document.getElementById("name").value;

        var sex=document.getElementById("sex").value;

        var phone=document.getElementById("phone").value;

        var idno=document.getElementById("idno").value;


        if(id.length!=4){
            alert("编号输入不合法")

        }

        if(name.length==0){
            alert("姓名输入不能为空")
        }
        if(sex!='男'&&sex!='女'){
            alert("性别输入不合法")

        }
        if(phone.length!=11){
            alert("电话输入不合法")


        }
        if(idno.length!=18){
            alert("身份证输入不合法")

        }


    }

</script>


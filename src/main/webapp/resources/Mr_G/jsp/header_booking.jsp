<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2022-06-03
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .text-input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 30px;
        height: 38px;
        width: 55%;
        font-size: 14px;
        font-weight: 700;
        float: left;

    }

    .text-startTime{
        width: 15%;
    }
    .text-endTime{
        width: 15%;
    }
    .button1{
        border-radius: 25px;
        width: 70px;
        height: 38px;
    }
    .button2{
        width: 10%;
    }
    select{
        width: 50%;
        height:30px;
    }
</style>
<div>
    <form action="#">
        请选择搜索方式：
        <select  class="choice" name="" id="choice" onchange="changeForm()" >
            <option value="" >请选择</option>
            <option value="1" >医生id</option>
            <option value="2" >时间</option>

        </select>

    </form>

    <br>
    <div class="type" id="doctorId" style="display: none;">
        <form action="#">
            <input type="text" class="text-input" placeholder="请输入医生id进行查询" value="" id="BDid">
            <input type="submit" class="button1" value="搜索" onclick="validdateFormBD()">
        </form>
    </div>
    <div class="type" id="Time" style="display: none;">
        <form action="#">

            开始时间：<input type="date" id="time" value=""/><input type="time" id="time" value=""/>
            结束时间：<input type="date"  id="time" value=""/><input type="time" id="time" value=""/>
            <input type="submit" value="搜索" onclick="validdateFormTime()">

        </form>
    </div>
</div>
<br>
<script>

    function changeForm(){
        var choice = document.getElementById("choice").value;

        var doc=document.querySelector("#doctorId");

        var time=document.querySelector("#Time");
        if(choice=="1"){
            doc.style.display="block"
            time.style.display="none"

        }
        else if(choice="2"){
            doc.style.display="none"
            time.style.display="block"
        }
        else{
            doc.style.display="none"
            time.style.display="none"
        }
    }
    function validdateFormBD(){
        alert("!");
        var id=document.getElementById("BDid").value;
        if(id.length!=4)
            alert("id输入不合法");
    }
    function validdateFormTime(){

        alert("请选择时间");
    }
</script>
function f1(){
    if(document.getElementById("pause").value==="继续") {
        document.getElementById("pause").value = "暂停"
        return false;
    }
    else(document.getElementById("pause").value==="暂停")
    document.getElementById("pause").value="继续"
}
function f2(){
    var d=new Date()
    var str=d.getHours()
    var c=document.getElementById("time").innerHTML

    if(c==="全天") {
        alert("你未到下班时间")
    }
        else if(c==="上午"){
            if(str>=12){
                if (window.confirm("你已到下班时间，确认是否下班")) {
                    //alert("确定");
                    window.open("welcome.html")
                    return true;
                } else {
                    //alert("取消");
                    return false;
                }
            }
            else {
                alert("你未到下班时间")
            }
        }
        else if(c==="下午"){
        if(str>=18){
            if (window.confirm("你已到下班时间，确认是否下班")) {
                //alert("确定");
                window.open("welcome.html")
                return true;
            } else {
                //alert("取消");
                return false;
            }
        }
        else {
            alert("你未到下班时间")
        }
    }
}
function f3(){
    if(document.getElementById("pause").value==="继续") {
        alert("您正处于暂停状态")
        return false
    }
    else {
        if(document.getElementById("call").value===""){
            alert("输入单号为空")
            return false
        }
        else{
            alert("已呼叫该患者，请耐心等待")
            return true;
        }

    }
}
function f4(){
    if(document.getElementById("pause").value==="继续") {
        alert("您正处于暂停状态")
        return false
    }
    else {
        if(document.getElementById("regist").value===""){
            alert("输入单号为空")
            return false
        }
        else {
            alert("已将该单号过号")
            return true
        }
    }
}

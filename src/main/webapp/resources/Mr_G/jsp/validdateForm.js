function validateForm(){

    var id=document.getElementById("id").value;
    var name=document.getElementById("name").value;
    var sex=document.getElementById("sex").value;
    var phone=document.getElementById("phone").value;
    var address=document.getElementById("address").value;
    var idno=document.getElementById("idno").value;
    var room=document.getElementById("room").value;
    if(id.length!=4){
        alert("编号输入不合法")


    }
    if(name==null){
        alert("输入不能为空")
    }
    if(phone.length!=11){
        alert("电话输入不合法")


    }
    if(idno.length!=18){
        alert("身份证输入不合法")

    }
    if(sex!='男'&&sex!='女'){
        alert("性别输入不合法")

    }
    if(room.length!=8){
        alert("诊室输入不合法")


    }
}
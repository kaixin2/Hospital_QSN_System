laydate.render({
  	elem: '#test1',
  	trigger: "click",
	type: 'date',
	min:getNowFormatDate(),
	format: 'yyyy-MM-dd',
});
laydate.render({
  	elem: '#test2',
    trigger: "click",
    type: 'time',
    format:'HH:mm',
});
function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = date.getFullYear() + seperator1 + month
			+ seperator1 + strDate + " " + date.getHours() + seperator2
			+ date.getMinutes() + seperator2 + date.getSeconds();
	return currentdate;
}

function getQueryVariable(variable)
{
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i=0;i<vars.length;i++) {
		var pair = vars[i].split("=");
		if(pair[0] == variable){return pair[1];}
	}
	return(false);
}
function registrationValidate(){
	var input_type1=document.getElementsByName('type1')[0];
	var input_type2=document.getElementsByName('type1')[1];
	var input_data=document.getElementsByName('date')[0];	
	var input_time=document.getElementsByName('time')[0];
	if(input_type1.checked){
		var input_searchType=document.getElementsByName('searchType')[0];
		if(input_data.value=='' || input_time.value=='' || input_searchType.value==0){
			document.getElementById('id').innerText='error...';
			return false;
		}else {
			window.location.href='addDoctors?type1='+getQueryVariable("type1")+
				'type2='+getQueryVariable("type2")+
				'date='+getQueryVariable("date")+
				'time='+getQueryVariable("time")+
				'searchType'+getQueryVariable("searchType");
			return true;
		}
	}else if(input_type2.checked){
				var input_listId=document.getElementsByName('listId')[0];
		if(input_data.value=='' || input_time.value=='' || input_listId.value==''){
			document.getElementById('id').innerText='error...';
			return false;
		}else
			return true;
	}else return true;

}

function check(){
	window.location.href='registrationInformation';
}


 function copy(id,type){
	document.getElementById("id").value=id;
		if(type != '取药'){
			window.location.href='doctorExpense?id='+id;
		}   else{
			window.location.href='drugExpense?id='+id;
		}  
    }
    
    
function revocation(id){
	window.location.href='revocation?id='+id;
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
    }

function reCheck(){
	var id=getQueryString('id');
	if(id==null){
		document.getElementById('information').innerText='未选择';
		return false;
	}else{
		return true;
	}
}

function deleteSeatAction(obj){
	var id = $(obj).prev().prev().prev().html().replace("排","_").replace("座","");
	var userId = getCookie('userId');
	var timeDate = $(obj).prev().html();
	var yearDate = timeDate.substr(6, 4);
	var monthDate = timeDate.substr(0, 2);
	var dayDate = timeDate.substr(3, 2);
	var HHMM=timeDate.substr(-11);
	var HH=HHMM.substr(0, 2);
	var MM=HHMM.substr(6, 2);
	var time = yearDate+monthDate+dayDate+HH+MM;
	var paramter = {'id':id, 'userId':userId, 'time':time};
	$.ajax({
		url:'seat/delete.do',
		data: paramter,
		dataType:'json',
		type:'POST',
		success:function(result){
//			console.log("success");
			loadUserSeatsAction();
		}
	});
}
function rec(obj)  
{  
    var mymessage=confirm("确认删除该条信息？");  
    if(mymessage==true)  
    {  
    	deleteSeatAction(obj);
    }
} 

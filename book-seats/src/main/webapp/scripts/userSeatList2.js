var SUCCESS=0;
var model = {};

$(function() {
	if(getCookie('userName')==undefined){
		location.href="login.html";
	}
});

function loadUserSeatsAction(){
	var userId = getCookie('userId');
	var data={userId:userId};
	$.ajax({
		url:'seat/find.do',
		data: data,
		dataType:'json',
		type:'POST',
		success:function(result){
			var list=result.data;
			model.updateSeatList(list);
		}
	});
};

model.updateSeatList=function(list){
	var template='<tr>'+'<td class="seat-list-id">[seats.id]座</td>'+'<td class="seat-list-name">[seats.name]</td>'+'<td class="seat-list-time">[seats.time]</td>'+'<td class="seat-list-delete" onclick="rec(this);">[seats.status]</td>'+'</tr>';
	this.seatList = list;
	var tbody=$('#userSeatList').empty();
	for(var i=0;i<this.seatList.length;i++){
		var seats=this.seatList[i];
		// id name
		var yearTime = seats.time.substr(0, 4);
		var monthTime = seats.time.substr(4, 2);
		var dayTime = seats.time.substr(6,2);
		var hour = seats.time.substr(8,2)+":"+"00";
		var minutes = seats.time.substr(-2)+":"+"00";
		var seatTime = monthTime+"/"+dayTime+"/"+yearTime+" "+hour+"-"+minutes;
		var tr=template.replace('[seats.id]',seats.id).replace('_','排').replace('[seats.name]',getCookie('userName')).replace('[seats.time]',seatTime).replace('[seats.status]',seats.status);
		//在DOM对象上绑定数据index
		tr = $(tr).data('index',i);
		tbody.append(tr);
	}
}

loadUserSeatsAction();






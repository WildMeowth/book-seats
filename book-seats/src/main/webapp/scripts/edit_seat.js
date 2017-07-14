//初始化
$(document).ready(fresh([]));
 $(".nav").load("./menu.html");

function fresh(list) {
	var $cart = $('#selected-seats'); //座位区
	var sc = $('#seat-map').seatCharts({
		map: [  //座位图
			'aaaaaaaaaa',
            'aaaaaaaaaa',
            'aaaaaaaaaa',
            'aaaaaaaa__',
            '__________',
			'aaaaaaaaaa',
			'aaaaaaaaaa',
			'aaaaaaaaaa',
			'aaaaaaaaaa',
            'aa__aa__aa'
		],
		naming : {
			top : false,
			getLabel : function (character, row, column) {
				return column;
			}
		},
		legend : { //定义图例
			node : $('#legend'),
			items : [
				[ 'a', 'available',   '可选座' ],
				[ 'a', 'unavailable', '已预定']
			]					
		},
		click: function () { //点击事件
			if (this.status() == 'available') { //可选座
				$cart.empty();
				$('<li onclick="removeli(this)">'+(this.settings.row+1)+'排'+this.settings.label+'座</li>')
					.attr('id', 'cart-item-'+this.settings.id)
					.data('seatId', this.settings.id)
					.appendTo($cart);
			
				return 'selected';
			} else if (this.status() == 'selected') { //已选中
					//删除已预订座位
					$('#cart-item-'+this.settings.id).remove();
					//可选座
					return 'available';
			} else if (this.status() == 'unavailable') { //已预定
				return 'unavailable';
			} else {
				return this.style();
			}
		}
	});
	for(var i = 1,arr1=[];i<=10;i++){
		for(var j=1;j<=10;j++){
			arr1.push(i+"_"+j);
		}
	}
//	console.log("1");
	sc.get(arr1).status('available');
	//已预定的座位
//	console.log(sc.get(arr1).status('available'));
	for(var i=0,arr=[];i<list.length;i++){
		var id=list[i].id;
		arr.push(id);
	}
	sc.get(arr).status('unavailable');
		
}


function removeli(obj){
	$(obj).remove();
}













var SUCCESS=0;
var model = {};

function loadSeatsAction(){
	var url='seat/list.do';
	var year=$('#birth_year>option:selected').text();
	var month=$('#birth_month').find("option:selected").text();
	var day=$('#birth_day').find("option:selected").text();
	month=month<10?"0"+month:""+month;
	day=day<10?"0"+day:day;
	var hour=$('#time-hour').find("option:selected").text().split(":")[0];
	var untilTime=$("#time-until").find("option:selected").val();
	var endTime=+hour+(+untilTime);
	endTime=endTime<10?"0"+endTime:endTime;
	var time=year+month+day+hour+endTime;
	var data={time:time};
//	console.log(year);
//	console.log(month);
//	console.log(day);
//	console.log(time);
//	console.log(data);
//	console.log(url);
	$.getJSON(url, data, function(result){
		if(result.state==SUCCESS){
			var list=result.data;
//			console.log(list);
			fresh(list);
		}
	});
};





function addSeatAction(){
	var id = $("#selected-seats").children().html().replace("排","_").replace("座","");
	var userId = getCookie('userId');
	var year=$('#birth_year>option:selected').text();
	var month=$('#birth_month').find("option:selected").text();
	var day=$('#birth_day').find("option:selected").text();
	month=month<10?"0"+month:""+month;
	day=day<10?"0"+day:day;	
	var hour=$('#time-hour').find("option:selected").text().split(":")[0];
	var untilTime=$("#time-until").find("option:selected").val();
	var endTime=+hour+(+untilTime);
	endTime=endTime<10?"0"+endTime:endTime;
	var time=year+month+day+hour+endTime;

	if(year=="年"||month=="月"||day=="日"||hour=="时间"){
		alert("请填写完整日期");
		return;
	}
	var status="未履约";
	var paramter = {'id':id, 'userId':userId, 'time':time, 'status':status};
//	console.log(id);
	$.ajax({
		url:'seat/add.do',
		data: paramter,
		dataType:'json',
		type:'POST',
		success:function(result){
			if(result.state==0){
				var list = result.data;
				loadSeatsAction();
	//			console.log(list);
	//			console.log("success");
			}else{
				alert(result.message);
			}
		}
	});
	
}

//显示当前时间当前用户座位预定信息
function loadSeatsForUserIdAndTimeAction(){
	var url='seat/listForUserIdAndTime.do';
	var userId = getCookie('userId');
	var year=$('#birth_year>option:selected').text();
	var month=$('#birth_month').find("option:selected").text();
	var day=$('#birth_day').find("option:selected").text();
	month=month<10?"0"+month:""+month;
	day=day<10?"0"+day:day;
	var hour=$('#time-hour').find("option:selected").text().split(":")[0];
	var untilTime=$("#time-until").find("option:selected").val();
	var endTime=+hour+(+untilTime);
	endTime=endTime<10?"0"+endTime:endTime;
	var time=year+month+day+hour+endTime;
	var data={userId:userId, time:time};

	$.getJSON(url, data, function(result){
		if(result.state==SUCCESS){
			var list=result.data;
			var seatId;
//			console.log(list.length);
			if(list.length==1){
				seatId=list[0].id.replace('_','排')+"座"
				$("#seat-qingkuang").html("<span>你当前时间已预订&nbsp;&nbsp;</span>"+"<span>"+seatId+"</span>");
			}else{
				$("#seat-qingkuang").html("<span>你该时段尚未预定座位</span>");
			}
		}
	});
};



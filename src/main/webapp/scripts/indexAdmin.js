/* 管理员页面脚本 */
var SUCCESS=0;
var model = {};
document.onkeydown=function(e){
	var keycode=document.all?event.keyCode:e.which;
	if(keycode==13){
		change();
	}
}

$("#seat-manage").click(function(){
	$("#admin-right-user").css('display','none');
	$("#admin-right-seat").css('display','block');
	$("#user-manage").removeClass("bgchange");
	$("#seat-manage").addClass("bgchange");;
})
$("#user-manage").click(function(){
	$("#admin-right-seat").css('display','none');
	$("#admin-right-user").css('display','block');
	$("#user-manage").addClass("bgchange");
	$("#seat-manage").removeClass("bgchange");;
})


$("#all").click(function(){   
    if(this.checked){   
        $("#Utbody :checkbox").prop("checked", true);  
    }else{   
    	$("#Utbody :checkbox").prop("checked", false);
    }   
});
function select(obj){
	$(obj).prevAll().removeClass("current");
	$(obj).nextAll().removeClass("current");
	$(obj).addClass("current");
}

$(function() {
	if(getCookie('userTitle')=='admin'){
		$("#admin-right-user").css('display','none');
		$("#admin-right-seat").css('display','block');
		$("#seat-manage").addClass("bgchange");
		$("#user-manage").removeClass("bgchange");;
		$(".name").html(getCookie('userName'));
		$('.admin-quit').click(quit);
		loadPagingAction();
	}else{
		delCookie('userName');
		delCookie('userId');
		location.href="adminLogin.html";
	}
});

function quit() {
	delCookie('userName');
	delCookie('userId');
	delCookie('userTitle');
	location.href="adminLogin.html";
};


//首页显示
function loadPagingAction(){
	var data={currentPage:1};
	$.ajax({
		url:'page/pageAll.do',
		data: data,
		dataType:'json',
		type:'POST',
		success:function(result){
			var list=result.data;
			model.loadInfoByPage(list);
		}
	});
}

//分页
function PagingAllAction(){
	if($('#search').val()==undefined||$('#search').val().trim()==""){
		var page=$(".current").html();
		var data={currentPage:page};
		$.ajax({
			url:'page/pageAll.do',
			data: data,
			dataType:'json',
			type:'POST',
			success:function(result){
				var list=result.data;
				model.loadInfoByPage(list);
			}
		});
	}
}
//分页二
function PagingAction(){
	var id=$('#search').val();
	if(id==undefined||id.trim()==""){
		return;
	}
	var page=$(".current").html();
	var data={currentPage:page, id:id};
	$.ajax({
		url:'page/page.do',
		data: data,
		dataType:'json',
		type:'POST',
		success:function(result){
			var list=result.data;
			model.loadInfoByPage(list);
		}
	});
}


model.loadInfoByPage=function(list){
	var template='<tr>'+
					'<td><input type="checkbox"></td>'+
					'<td>[id]</td>'+
					'<td>[name]</td>'+
					'<td>[seatId]</td>'+
					'<td>[seatTime]</td>'+
					'<td>[status]</td>'+
				'</tr>'
	this.List = list;
	var tbody=$('#Utbody').empty();
	for(var i=0;i<this.List.length;i++){
		var userInfo=this.List[i];
		
		var tr=template.replace('[id]',userInfo.id).replace('[name]',userInfo.name).replace('[seatId]',userInfo.seatId).replace('[seatTime]',userInfo.seatTime).replace('[status]',userInfo.status);
		//在DOM对象上绑定数据index
		tr = $(tr).data('index',i);
		tbody.append(tr);
	}
}

function change(){
	if($('#search').val()==undefined||$('#search').val().trim()==""){
		PagingAllAction();
	}else{
		PagingAction();
	}
}

function deleteAction(){
	var checkboxes=$("#Utbody :checkbox")
	var userId;
	var seatId;
	var seatTime;
	console.log(11111);
	for(var i=0;i<checkboxes.length;i++){
		if(checkboxes[i].checked){
			userId = $(checkboxes[i]).parent().next().html();
			seatId = $(checkboxes[i]).parent().next().next().next().html()
			seatTime = $(checkboxes[i]).parent().next().next().next().next().html();
		}
	}
	var data = {'id':seatId, 'userId':userId, 'time':seatTime};
	console.log(data)
	$.ajax({
		url:'seat/delete.do',
		data: data,
		dataType:'json',
		type:'POST',
		success:function(result){
//			console.log("success");
			loadPagingAction();
		}
	});
}
function rec()  
{  
    var mymessage=confirm("确认删除该条信息？");  
    if(mymessage==true)  
    {  
    	deleteAction();
    }
} 

//创建新的学生用户
function newUser(){
	var id=$("#new-user-id").val();
	var name=$("#new-user-name").val();
	var pwd=$("#new-user-pwd").val();
	var data={id:id, name:name, password:pwd};
	$.ajax({
		url:'user/addUser.do',
		data: data,
		dataType:'json',
		type:'POST',
		success:function(result){
			if(result.state==0){
				newUserTitle();
			} else{
				alert(result.message);
			}
		},
		error:function(){alert('Ajax请求失败')}
	});
}
//插用户title
function newUserTitle(){
	var id=$("#new-user-id").val();
	var title="student";
	var data={id:id, title:title};
	$.ajax({
		url:'userIfoTitle/addTitle.do',
		data: data,
		dataType:'json',
		type:'POST',
		success:function(result){
			if(result.state==0){
				alert("创建成功");
				return;
			} 
			alert(result.message);
		},
		error:function(){alert('Ajax请求失败')}
	});
}



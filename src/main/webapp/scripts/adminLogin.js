/* 登录界面脚本程序 */

$(function() {
	$('#btn').click(loginAction);
	$('#user').blur(checkId);
	$('#pwd').blur(checkPassword);
	
});


// 登录按钮的动作
function loginAction() {
	// 收集用户名和密码数据
	var id = $('#user').val();
	var password = $('#pwd').val();
	// 验证用户名和密码
	var pass = checkId() + checkPassword();
	if (pass != 2) {
		return;
	}
	var paramter={'id':id,'password':password};
	// 发送Ajax请求
	$.ajax({
		url:'userIfo/login.do',
		data:paramter,
		dataType:'json',
		type:'POST',
		success:function(result){
			//{state:0,data:,message}
			if(result.state==0){
				var user = result.data;
				setCookie('userId',user.id);
				setCookie('userName',user.name);
				setCookie('userTitle',user.title);
				location.href="indexAdmin.html";
				return;
			} else if(result.state==2){
				//用户名错误
				$('#count_msg').html(result.message);
				return;
			} else if(result.state==3) {
				$('#password_msg').html(result.message);
				return;
			}
			alert(result.message);
		},
		error:function(){alert('Ajax请求失败')}
	});
}

function checkId() {
	var id = $('#user').val();
	if (id == null || id == "") {
		// 提示错误
		$('#count_msg').html('不能空');
		return false;
	}
	var reg = /^\w{5,12}$/;
	if (!reg.test(id)) {
		$('#count_msg').html('长度不对');
		return false;
	}
	$('#count_msg').empty();
	return true;
}

function checkPassword() {
	var password = $('#pwd').val();
	if (password == null || password == "") {
		// 提示错误
		$('#password_msg').html('不能空');
		return false;
	}
	var reg = /^\w{3,18}$/;
	if (!reg.test(password)) {
		$('#password_msg').html('长度不对');
		return false;
	}
	$('#password_msg').empty();
	return true;
}
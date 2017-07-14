/* 登录界面脚本程序 */

$(function() {
	if(getCookie('userName')==undefined){
		location.href="login.html";
	}
	$('#btn1').click(cofirmOldPwdAction);
	$('#pwd1').blur(checkPassword);
	
});



// 验证旧密码的动作
function cofirmOldPwdAction() {
//	console.log('login click');
	// 收集用户名和密码数据
	var id = getCookie('userId');
	var password = $('#pwd1').val();
	// 验证用户名和密码
	var pass = checkPassword();
	if (!pass) {
		return;
	}
	var paramter={'id':id,'password':password};
	// 发送Ajax请求
	$.ajax({
		url:'user/login.do',
		data:paramter,
		dataType:'json',
		type:'POST',
		success:function(result){
			//{state:0,data:,message}
			if(result.state==0){
				updatePwdAction();
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

function checkPassword() {
	var password = $('#pwd1').val();
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

function updatePwdAction(){
	var pass = checkNewPassword()+checkFinalPassword();
	if(pass!=2){
		//测试///
		return;
	}
	var url="user/updatePwd.do";
	var id = getCookie('userId');
	var name= getCookie('userName');
	var pwd = $('#new_password').val();
	var confirm = $('#final_password').val();
	//向服务器发送(还可以使用$.ajax)
	var data={'id':id, 'name':name, 'password':pwd, 'token':'', 'confirm':confirm};
	$.post(url, data, function(result){
		if(result.state==0){
			$('.div-person-notify').html("<div>修改成功！ 3秒后返回首页</div>");
			setTimeout(function () {
				$('.div-person-notify').html("<div>修改成功！ 2秒后返回首页</div>");
				setTimeout(function () {
					$('.div-person-notify').html("<div>修改成功！ 1秒后返回首页</div>");
					setTimeout(function () {
						delCookie('userId');
						delCookie('userName');
						location.href="index.html";
					}, 1000);
				}, 1000);
			}, 1000);		
		} else if(result.state==2){
			$('#warning_1 span').html(result.message).parent().show();
		} else if(result.state==3){
			$('#warning_2 span').html(result.message).parent().show();
		} else{
			alert(result.message);
		}
	});
}

function checkNewPassword(){
	var pwd = $('#new_password').val();
	var reg = /^\w{3,18}$/;
	if(!reg.test(pwd)){
		$('#password_msg2').html("不合规则").parent().show();
		return false;
	}
	$('#password_msg2').hide();
	return true;
}
function checkFinalPassword(){
	var pwd1 = $('#new_password').val();
	var pwd2 = $('#final_password').val();
	if(pwd1!=pwd2){
		$('#password_msg3').html("密码输入不一致").parent().show();
		return false;
	}
	$('#password_msg3').hide();
	return true;
}

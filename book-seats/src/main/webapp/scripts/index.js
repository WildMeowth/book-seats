$(function() {
	if(getCookie('userName')==undefined){
		$("#wel").html('游客，请<a href="login.html">登录</a>');
//		console.log(11111);
	}else if(getCookie('userTitle')=='admin'){
		delCookie('userName');
		delCookie('userId');
		delCookie('userTitle');
	}else{
		$("#wel").html('欢迎你，');
		$("#userName").html(getCookie('userName'));
		$("#quit").html('退出');
//		console.log(11111222222);
	}
//	console.log(111111);
	$('#quit').click(quit);
//	console.log(1111);
//	console.log(getCookie('userName'));
});
function quit() {
	delCookie('userName');
	delCookie('userId');
};
package cn.wildMeowth.bookSeats.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wildMeowth.bookSeats.entity.UserIfo;
import cn.wildMeowth.bookSeats.service.PasswordException;
import cn.wildMeowth.bookSeats.service.UserIdException;
import cn.wildMeowth.bookSeats.service.UserIfoService;
import cn.wildMeowth.bookSeats.util.JsonResult;



@Controller
@RequestMapping("/userIfo")
public class UserIfoController extends AbstractController {

	@Resource
	private UserIfoService userIfoService;

	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<UserIfo> login(String id, String password, HttpServletResponse res) {
			UserIfo userIfo = userIfoService.login(id, password);
			Cookie cookie = new Cookie("token", userIfo.getToken());
			cookie.setPath("/");
			res.addCookie(cookie);
			return new JsonResult<UserIfo>(userIfo);
	}
	
	
	// JSON:{state:0, data:{id:...}, message:}
	// JSON:{state:0, data:null, message:Ãû×Ö¿Õ}

	@ExceptionHandler(UserIdException.class)
	@ResponseBody
	public JsonResult userId(UserIdException e) {
		e.printStackTrace();
		return new JsonResult(2, e);
	}

	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public JsonResult password(PasswordException e) {
		e.printStackTrace();
		return new JsonResult(3, e);
	}

	/*@ExceptionHandler
	@ResponseBody
	public JsonResult exp(Exception e) {
		e.printStackTrace();
		return new JsonResult(e);
	}*/

}

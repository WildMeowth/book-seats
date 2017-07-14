package cn.wildMeowth.bookSeats.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wildMeowth.bookSeats.entity.User;
import cn.wildMeowth.bookSeats.service.PasswordException;
import cn.wildMeowth.bookSeats.service.UserIdException;
import cn.wildMeowth.bookSeats.service.UserService;
import cn.wildMeowth.bookSeats.util.JsonResult;



@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

	@Resource
	private UserService userService;

	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<User> login(String id, String password, HttpServletResponse res) {
			User user = userService.login(id, password);
			Cookie cookie = new Cookie("token", user.getToken());
			cookie.setPath("/");
			res.addCookie(cookie);
			return new JsonResult<User>(user);
	}
	
	@RequestMapping("/updatePwd.do")
	@ResponseBody
	public JsonResult<User> updatePwd(String id, String name, String password, String token,String confirm) {
		User user = userService.updatePwd(id ,name, password, token, confirm);
		return new JsonResult<User>(user);
	}
	
	@RequestMapping("/addUser.do")
	@ResponseBody
	public JsonResult<User> addUser(String id, String name, String password) {
			User user = userService.addUser(id, name, password);
			return new JsonResult<User>(user);
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

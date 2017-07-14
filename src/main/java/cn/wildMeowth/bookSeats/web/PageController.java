package cn.wildMeowth.bookSeats.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wildMeowth.bookSeats.entity.PageBean;
import cn.wildMeowth.bookSeats.entity.User;
import cn.wildMeowth.bookSeats.entity.User2;
import cn.wildMeowth.bookSeats.entity.UserIfo;
import cn.wildMeowth.bookSeats.service.PasswordException;
import cn.wildMeowth.bookSeats.service.UserIdException;
import cn.wildMeowth.bookSeats.service.UserIfoService;
import cn.wildMeowth.bookSeats.service.UserService2;
import cn.wildMeowth.bookSeats.util.JsonResult;



@Controller
@RequestMapping("/page")
public class PageController extends AbstractController {

	@Resource
	private UserService2 userService2;

	@RequestMapping("/page.do")
	@ResponseBody
	public JsonResult<List<User2>> findByPage(int currentPage, String id) {
		List<User2> list=userService2.findByPage(currentPage,id).getLists();
		return new JsonResult<List<User2>>(list);
	}
	
	@RequestMapping("/pageAll.do")
	@ResponseBody
	public JsonResult<List<User2>> findByPageAll(int currentPage) {
		List<User2> list=userService2.findByPageAll(currentPage).getLists();
		return new JsonResult<List<User2>>(list);
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

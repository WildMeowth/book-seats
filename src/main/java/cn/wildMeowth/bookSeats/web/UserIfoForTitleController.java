package cn.wildMeowth.bookSeats.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wildMeowth.bookSeats.entity.UserIfo2;
import cn.wildMeowth.bookSeats.service.PasswordException;
import cn.wildMeowth.bookSeats.service.UserIdException;
import cn.wildMeowth.bookSeats.service.UserIfoService2;
import cn.wildMeowth.bookSeats.util.JsonResult;



@Controller
@RequestMapping("/userIfoTitle")
public class UserIfoForTitleController extends AbstractController {

	@Resource
	private UserIfoService2 userIfoService2;

	@RequestMapping("/addTitle.do")
	@ResponseBody
	public JsonResult<UserIfo2> addUser(String id, String title) {
			UserIfo2 userIfo2 = userIfoService2.addTitle(id, title);
			return new JsonResult<UserIfo2>(userIfo2);
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

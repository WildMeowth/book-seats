package cn.wildMeowth.bookSeats.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wildMeowth.bookSeats.util.JsonResult;



public abstract class AbstractController {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler
	@ResponseBody
	public JsonResult exp(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}
	
}

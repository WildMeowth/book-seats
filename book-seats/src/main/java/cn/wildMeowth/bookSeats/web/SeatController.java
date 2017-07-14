package cn.wildMeowth.bookSeats.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wildMeowth.bookSeats.entity.Seat;
import cn.wildMeowth.bookSeats.service.SeatService;
import cn.wildMeowth.bookSeats.util.JsonResult;

@Controller
@RequestMapping("/seat")
public class SeatController extends AbstractController {
	@Resource
	private SeatService seatService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Map<String, String>>> list(String time){
		List<Map<String, String>> list = seatService.listSeats(time);
		return new JsonResult<List<Map<String, String>>>(list);
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult<Seat> addSeat(String id, String userId, String time, String status){
		Seat seat = seatService.addSeat(id, userId, time, status);
		return new JsonResult<Seat>(seat);
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult<List<Map<String, String>>> listByUserId(String userId) {
		List<Map<String, String>> list = seatService.listUserSeats(userId);
		return new JsonResult<List<Map<String, String>>>(list);
	}
	
	@RequestMapping("/findforNo.do")
	@ResponseBody
	public JsonResult<List<Map<String, String>>> listByUserIdforNo(String userId) {
		List<Map<String, String>> list = seatService.listUserSeatsforNo(userId);
		return new JsonResult<List<Map<String, String>>>(list);
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public JsonResult<Seat> deleteSeat(String id, String userId, String time, String status){
		Seat seat = seatService.deleteSeat(id, userId, time, status);
		return new JsonResult<Seat>(seat);
	}
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult<Seat> update(String id, String userId, String time, String status){
		Seat seat = seatService.updateStatus(id, userId, time, status);
		return new JsonResult<Seat>(seat);
	}
	
	@RequestMapping("/listForUserIdAndTime.do")
	@ResponseBody
	public JsonResult<List<Map<String, String>>> list(String userId, String time){
		List<Map<String, String>> list = seatService.listSeatsByUserIdAndTime(userId, time);
		return new JsonResult<List<Map<String, String>>>(list);
	}
}

package cn.bookSeats.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wildMeowth.bookSeats.entity.PageBean;
import cn.wildMeowth.bookSeats.entity.Seat;
import cn.wildMeowth.bookSeats.entity.User;
import cn.wildMeowth.bookSeats.entity.User2;
import cn.wildMeowth.bookSeats.service.PasswordException;
import cn.wildMeowth.bookSeats.service.SeatService;
import cn.wildMeowth.bookSeats.service.UserIdException;
import cn.wildMeowth.bookSeats.service.UserService;
import cn.wildMeowth.bookSeats.service.UserService2;

public class UserServiceTest {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml", "spring-service.xml");
	}
	
	@Test
	public void testpagezcx() {
		UserService2 service = ctx.getBean("userService2",UserService2.class);
		PageBean<User2> a = service.findByPage(1,"201303090216");
		System.out.println(a.getCurrPage()+","+a.getId()+","+a.getLists()+","+a.getPageSize()+","+a.getTotalCount()+","+a.getTotalPage());
		
		
	}
	@Test
	public void testpage() {
		UserService2 service = ctx.getBean("userService2",UserService2.class);
		PageBean<User2> a = service.findByPageAll(1);
		System.out.println(a.getCurrPage()+","+a.getLists()+","+a.getPageSize()+","+a.getTotalCount()+","+a.getTotalPage());
		
		
	}
	@Test
	public void testLogin() {
		UserService service = ctx.getBean("userService",UserService.class);
		String id="201303090216";
		String password="1234";
		User user = service.login(id, password);
		System.out.println(user);
	}
	
	@Test
	public void testaddSeat(){
		SeatService service = ctx.getBean("seatService",SeatService.class);
		String id = "4_5";
		String userId = "201303090203";
		String time="20171108";
		Seat seat = service.addSeat(id, userId, time, time);
		System.out.println(seat);
	}
	
	@Test
	public void testfindSeatByUserId(){
		SeatService service = ctx.getBean("seatService",SeatService.class);
		String userId = "201303090216";
		List<Map<String, String>> seat = service.listUserSeats(userId);
		System.out.println(seat);
	}
	
}

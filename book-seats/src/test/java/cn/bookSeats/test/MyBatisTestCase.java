package cn.bookSeats.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wildMeowth.bookSeats.dao.SeatDao;
import cn.wildMeowth.bookSeats.dao.UserDao;
import cn.wildMeowth.bookSeats.dao.UserDao2;
import cn.wildMeowth.bookSeats.entity.PageBean;
import cn.wildMeowth.bookSeats.entity.Seat;
import cn.wildMeowth.bookSeats.entity.User2;
import cn.wildMeowth.bookSeats.service.UserService2;

public class MyBatisTestCase {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	}
	
	
	@Test
	public void testFindUserById(){
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		String id="201303090216";
		System.out.println(dao.findUserById(id));
	}

	
	@Test
	public void testFindSeatByUserId(){
		SeatDao dao = ctx.getBean("seatDao", SeatDao.class);
		String userId = "201303090216";
		System.out.println(dao.findSeatByUserId(userId));
	}
	@Test
	public void testFindSeatByTime(){
		SeatDao dao = ctx.getBean("seatDao", SeatDao.class);
		String time = "20170901";
		System.out.println(dao.findSeatByTime(time));
	}
	@Test
	public void testaddSeat(){
		SeatDao dao = ctx.getBean("seatDao", SeatDao.class);
		String id="4_5";
		String userId="201303090203";
		String time="20171108";
		Seat seat = new Seat(id,userId,time, time);
		dao.addSeat(seat);
		System.out.println(seat);
	}
	@Test
	public void testfindSeatByUserId(){
		SeatDao dao = ctx.getBean("seatDao", SeatDao.class);
		String userId="201303090203";
		System.out.println(dao.findSeatByUserId(userId));
	}
	
}

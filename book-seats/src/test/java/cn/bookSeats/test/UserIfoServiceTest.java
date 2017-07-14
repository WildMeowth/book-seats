package cn.bookSeats.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wildMeowth.bookSeats.dao.UserIfoDao;

public class UserIfoServiceTest {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml", "spring-service.xml");
	}
	
	
	
	@Test
	public void testFindUserById(){
		UserIfoDao dao = ctx.getBean("userIfoDao",UserIfoDao.class);
		String id="admin";
		System.out.println(dao.findAdminById(id));
		System.out.println("admin".equals(dao.findAdminById(id).getTitle()));
	}
	
}

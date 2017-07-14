package cn.wildMeowth.bookSeats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wildMeowth.bookSeats.dao.UserIfoDao2;
import cn.wildMeowth.bookSeats.entity.UserIfo2;

@Service("userIfoService2")
public class UserIfoServiceImpl2 implements UserIfoService2 {
	
	@Autowired
	private UserIfoDao2 userIfoDao2;
	
	public UserIfo2 addTitle(String id, String title) throws UserNotFoundException, PasswordException {
		
		id = id.trim();
		UserIfo2 userIfo2 = new UserIfo2(id, title);
		userIfoDao2.saveTitle(userIfo2);
		
		return userIfo2;
	}



}

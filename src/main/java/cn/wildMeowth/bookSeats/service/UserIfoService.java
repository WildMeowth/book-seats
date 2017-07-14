package cn.wildMeowth.bookSeats.service;

import cn.wildMeowth.bookSeats.entity.UserIfo;

public interface UserIfoService {

	UserIfo login(String id, String password) throws UserTitleException, UserIdException, PasswordException;
	
}

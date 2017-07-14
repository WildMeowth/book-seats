package cn.wildMeowth.bookSeats.service;


import cn.wildMeowth.bookSeats.entity.UserIfo2;

public interface UserIfoService2 {

	public UserIfo2 addTitle(String id, String title) throws UserNotFoundException, PasswordException;
}

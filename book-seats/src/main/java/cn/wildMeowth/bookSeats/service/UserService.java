package cn.wildMeowth.bookSeats.service;


import cn.wildMeowth.bookSeats.entity.User;

public interface UserService {

	User login(String id, String password) throws UserIdException, PasswordException;
	User updatePwd (String id, String name, String password, String token,String confirm) throws UserNotFoundException ;
	
	public User addUser(String id, String name, String password) throws UserNotFoundException, PasswordException;

}

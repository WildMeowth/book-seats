package cn.wildMeowth.bookSeats.dao;

import cn.wildMeowth.bookSeats.entity.User;

public interface UserDao {

	User findUserById(String id);
	int updatePwd(User user);
	void saveUser(User user);
	
}

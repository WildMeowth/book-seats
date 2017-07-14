package cn.wildMeowth.bookSeats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wildMeowth.bookSeats.dao.UserIfoDao;
import cn.wildMeowth.bookSeats.entity.UserIfo;
import cn.wildMeowth.bookSeats.util.Utils;

@Service("userIfoService")
public class UserIfoServiceImpl implements UserIfoService {
	
	@Autowired
	private UserIfoDao userIfoDao;
	public UserIfo login(String id, String password) throws UserTitleException, UserIdException, PasswordException {
		if(id == null || id.trim().isEmpty()){
			throw new UserIdException("账号不能为空");
		}
		String reg1 = "^\\w{5,12}$";
		String reg2 = "^\\w{3,10}$";
		if(!id.matches(reg1)){
			throw new UserIdException("账号不合规");
		}
		if(password == null || password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		if(!password.matches(reg2)){
			throw new PasswordException("密码不合规");
		}
		//查询用户数据
		UserIfo userIfo = userIfoDao.findAdminById(id);
		
		//判断用户匹配情况
		
		if(userIfo==null){
			throw new UserIdException("没有该用户");
		}
		if(!("admin".equals(userIfo.getTitle()))){
			throw new UserTitleException("没有管理员权限");
		}
		String md5 = Utils.crypt(password);
		if(userIfo.getPassword().equals(md5)){
			//登陆成功
			return userIfo;
		}
		throw new PasswordException("密码错误");
	}



}

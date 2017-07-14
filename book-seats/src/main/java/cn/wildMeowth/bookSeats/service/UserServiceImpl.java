package cn.wildMeowth.bookSeats.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wildMeowth.bookSeats.dao.UserDao;
import cn.wildMeowth.bookSeats.entity.User;
import cn.wildMeowth.bookSeats.util.Utils;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	public User login(String id, String password) throws UserIdException, PasswordException {
		if(id == null || id.trim().isEmpty()){
			throw new UserIdException("账号不能为空");
		}
		String reg1 = "^\\d{12}$";
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
		User user = userDao.findUserById(id);
		
		//判断用户匹配情况
		if(user==null){
			throw new UserIdException("没有该用户");
		}
		String md5 = Utils.crypt(password);
		if(user.getPassword().equals(md5)){
			//登陆成功
			return user;
		}
		throw new PasswordException("密码错误");
	}
	public User updatePwd(String id, String name, String password, String token, String confirm) throws UserNotFoundException {
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("不能为空");
		}
		String reg1 = "^\\w{3,18}$";
		if(!password.matches(reg1)){
			throw new PasswordException("密码不合理");
		}
		password = password.trim();
		if(!password.equals(confirm)){
			throw new PasswordException("确认密码不匹配");
		}
		String pwd = Utils.crypt(password);
		User user = new User(id, name, pwd, token);
		int n = userDao.updatePwd(user);
		if(n!=1){
			throw new UserNotFoundException();
		}
		return user;
	}
	public User addUser(String id, String name, String password) throws UserNotFoundException, PasswordException {
		//id
		if (id == null || id.trim().isEmpty()) {
			throw new UserNotFoundException("不能为空");
		}
		String reg1 = "^\\d{12}$";
		if (!id.matches(reg1)) {
			throw new UserNotFoundException("不合理");
		}
		
		//name
		if (name == null || name.trim().isEmpty()) {
			throw new UserNotFoundException("不能为空");
		}
		String reg2 = "^\\w{3,10}$";
		if (!name.matches(reg2)) {
			throw new UserNotFoundException("不合理");
		}
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("不能为空");
		}
		String reg3 = "^\\w{3,18}$";
		if(!name.matches(reg3)){
			throw new PasswordException("密码不合理");
		}
		password = password.trim();
		id = id.trim();
		name=name.trim();
		//检验用户名是否重复
		User guy = userDao.findUserById(id);
		if(guy!=null){
			throw new UserNotFoundException("Id已被使用");
		}
		String token="";
		String pwd = Utils.crypt(password);
		User user = new User(id, name, pwd, token);
		userDao.saveUser(user);
		
		return user;
	}

}

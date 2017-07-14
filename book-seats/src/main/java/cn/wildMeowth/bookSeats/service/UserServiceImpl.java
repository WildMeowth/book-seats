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
			throw new UserIdException("�˺Ų���Ϊ��");
		}
		String reg1 = "^\\d{12}$";
		String reg2 = "^\\w{3,10}$";
		if(!id.matches(reg1)){
			throw new UserIdException("�˺Ų��Ϲ�");
		}
		if(password == null || password.trim().isEmpty()){
			throw new PasswordException("���벻��Ϊ��");
		}
		if(!password.matches(reg2)){
			throw new PasswordException("���벻�Ϲ�");
		}
		//��ѯ�û�����
		User user = userDao.findUserById(id);
		
		//�ж��û�ƥ�����
		if(user==null){
			throw new UserIdException("û�и��û�");
		}
		String md5 = Utils.crypt(password);
		if(user.getPassword().equals(md5)){
			//��½�ɹ�
			return user;
		}
		throw new PasswordException("�������");
	}
	public User updatePwd(String id, String name, String password, String token, String confirm) throws UserNotFoundException {
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("����Ϊ��");
		}
		String reg1 = "^\\w{3,18}$";
		if(!password.matches(reg1)){
			throw new PasswordException("���벻����");
		}
		password = password.trim();
		if(!password.equals(confirm)){
			throw new PasswordException("ȷ�����벻ƥ��");
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
			throw new UserNotFoundException("����Ϊ��");
		}
		String reg1 = "^\\d{12}$";
		if (!id.matches(reg1)) {
			throw new UserNotFoundException("������");
		}
		
		//name
		if (name == null || name.trim().isEmpty()) {
			throw new UserNotFoundException("����Ϊ��");
		}
		String reg2 = "^\\w{3,10}$";
		if (!name.matches(reg2)) {
			throw new UserNotFoundException("������");
		}
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("����Ϊ��");
		}
		String reg3 = "^\\w{3,18}$";
		if(!name.matches(reg3)){
			throw new PasswordException("���벻����");
		}
		password = password.trim();
		id = id.trim();
		name=name.trim();
		//�����û����Ƿ��ظ�
		User guy = userDao.findUserById(id);
		if(guy!=null){
			throw new UserNotFoundException("Id�ѱ�ʹ��");
		}
		String token="";
		String pwd = Utils.crypt(password);
		User user = new User(id, name, pwd, token);
		userDao.saveUser(user);
		
		return user;
	}

}

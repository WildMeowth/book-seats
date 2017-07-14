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
			throw new UserIdException("�˺Ų���Ϊ��");
		}
		String reg1 = "^\\w{5,12}$";
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
		UserIfo userIfo = userIfoDao.findAdminById(id);
		
		//�ж��û�ƥ�����
		
		if(userIfo==null){
			throw new UserIdException("û�и��û�");
		}
		if(!("admin".equals(userIfo.getTitle()))){
			throw new UserTitleException("û�й���ԱȨ��");
		}
		String md5 = Utils.crypt(password);
		if(userIfo.getPassword().equals(md5)){
			//��½�ɹ�
			return userIfo;
		}
		throw new PasswordException("�������");
	}



}

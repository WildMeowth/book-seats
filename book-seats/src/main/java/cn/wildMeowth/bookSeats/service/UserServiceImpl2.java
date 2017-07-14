package cn.wildMeowth.bookSeats.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wildMeowth.bookSeats.dao.UserDao2;
import cn.wildMeowth.bookSeats.entity.PageBean;
import cn.wildMeowth.bookSeats.entity.User2;

@Service("userService2")
public class UserServiceImpl2 implements UserService2 {
	
	@Resource
	private UserDao2 userDao2;
	
	public PageBean<User2> findByPage (int currentPage, String id) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<User2> pageBean = new PageBean<User2>();

        //封装当前页数
	    pageBean.setCurrPage(currentPage);
	    
	    pageBean.setId(id);
	
	    //每页显示的数据
	    int pageSize=6;
	    pageBean.setPageSize(pageSize);
	
	    //封装总记录数
	    int totalCount = userDao2.selectCount(id);
	    pageBean.setTotalCount(totalCount);
	
	    //封装总页数
	    double tc = totalCount;
	    Double num =Math.ceil(tc/pageSize);//向上取整
	    pageBean.setTotalPage(num.intValue());
	
	    map.put("start",(currentPage-1)*pageSize);
	    map.put("size", pageBean.getPageSize());
	    map.put("id", pageBean.getId());
	    //封装每页显示的数据
	    List<User2> lists = userDao2.findByPage(map);
	    pageBean.setLists(lists);
	
	    return pageBean;
	}

	public PageBean<User2> findByPageAll(int currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<User2> pageBean = new PageBean<User2>();

        //封装当前页数
	    pageBean.setCurrPage(currentPage);
	    
	
	    //每页显示的数据
	    int pageSize=6;
	    pageBean.setPageSize(pageSize);
	
	    //封装总记录数
	    int totalCount = userDao2.selectCountAll();
	    pageBean.setTotalCount(totalCount);
	
	    //封装总页数
	    double tc = totalCount;
	    Double num =Math.ceil(tc/pageSize);//向上取整
	    pageBean.setTotalPage(num.intValue());
	
	    map.put("start",(currentPage-1)*pageSize);
	    map.put("size", pageBean.getPageSize());
	    //封装每页显示的数据
	    List<User2> lists = userDao2.findByPageAll(map);
	    pageBean.setLists(lists);
	
	    return pageBean;
	}

}

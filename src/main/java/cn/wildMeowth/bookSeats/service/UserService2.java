package cn.wildMeowth.bookSeats.service;

import cn.wildMeowth.bookSeats.entity.PageBean;
import cn.wildMeowth.bookSeats.entity.User2;

public interface UserService2 {

    PageBean<User2> findByPage(int currentPage,String id);
    PageBean<User2> findByPageAll(int currentPage);
}

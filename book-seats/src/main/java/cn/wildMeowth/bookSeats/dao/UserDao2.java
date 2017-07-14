package cn.wildMeowth.bookSeats.dao;

import java.util.HashMap;
import java.util.List;

import cn.wildMeowth.bookSeats.entity.User2;

public interface UserDao2 {
    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    List<User2> findByPage(HashMap<String,Object> map);

    List<User2> findByPageAll(HashMap<String,Object> map);
    
    int selectCount(String id);
    
    int selectCountAll();
}

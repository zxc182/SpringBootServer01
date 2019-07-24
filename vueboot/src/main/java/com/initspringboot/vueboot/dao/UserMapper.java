package com.initspringboot.vueboot.dao;

import com.initspringboot.vueboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{

    List<User> selectAll();

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);

    /**
     * 插入
     * @param user
     * @return
     */
    int insert(User user);
}

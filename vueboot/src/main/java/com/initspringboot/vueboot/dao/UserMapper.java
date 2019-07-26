package com.initspringboot.vueboot.dao;

import com.github.pagehelper.Page;
import com.initspringboot.vueboot.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


public interface UserMapper extends Mapper<User> {

    /*List<User> selectAll(User user);

    int insert(User user);*/

    //List<User> PageList(User user);
}

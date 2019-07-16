package com.initspringboot.vueboot.dao;

import com.initspringboot.vueboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{

    List<User> selectAll();
}

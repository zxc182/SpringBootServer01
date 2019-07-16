package com.initspringboot.vueboot.service.impl;

import com.initspringboot.vueboot.dao.UserMapper;
import com.initspringboot.vueboot.entity.User;
import com.initspringboot.vueboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }
}

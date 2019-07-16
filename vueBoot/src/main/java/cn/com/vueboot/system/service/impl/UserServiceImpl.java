package cn.com.vueboot.system.service.impl;

import cn.com.vueboot.system.dao.UserMapper;
import cn.com.vueboot.system.emtity.User;
import cn.com.vueboot.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxc on 2019/5/21.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    public User findUser(User user){
        return userMapper.findUser(user);
    }
}

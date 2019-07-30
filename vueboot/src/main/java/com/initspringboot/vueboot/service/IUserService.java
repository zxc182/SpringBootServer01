package com.initspringboot.vueboot.service;


import com.github.pagehelper.Page;
import com.initspringboot.vueboot.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IUserService extends IBaseService<User> {

    //List<User> pageList(User user,int pageNum, int pageSize);

    //void add(User user);
    void updateUser(User user);

}

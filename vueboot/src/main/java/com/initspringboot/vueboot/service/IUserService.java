package com.initspringboot.vueboot.service;


import com.initspringboot.vueboot.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
}

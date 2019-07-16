package com.initspringboot.vueboot.controller;

import com.initspringboot.vueboot.entity.User;
import com.initspringboot.vueboot.service.IUserService;
import com.initspringboot.vueboot.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseResult<List> findAll(){
        List<User> data = userService.findAll();
        return new ResponseResult<>(SUCCESS,data);
    }
}

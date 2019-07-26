package com.initspringboot.vueboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.initspringboot.vueboot.entity.User;
import com.initspringboot.vueboot.service.IUserService;
import com.initspringboot.vueboot.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@RestController
@Api(tags="用户管理")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @PostMapping("/findAll")
    @ApiOperation(value="查询用户数据", notes = "查询用户数据")
    public ResponseResult<PageInfo> findAll(
            @RequestBody  User user,
            int pageNum,
            int pageSize){
        PageInfo<User> data = userService.queryPageListByWhere(user,pageNum,pageSize);
        //List<User> data = userService.pageList(user,pageNum,pageSize);
        return new ResponseResult<>(SUCCESS,data);
    }

    @PostMapping("/add")
    @ApiOperation(value="插入用户数据", notes = "插入用户数据")
    public ResponseResult<Void> add(
            @ApiParam(name="user",value="用户数据",required=true) @RequestBody User user
    ){
        //userService.add(user);
        return new ResponseResult<>(SUCCESS);
    }

}

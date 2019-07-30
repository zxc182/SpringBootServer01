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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

import javax.security.sasl.AuthenticationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags="用户管理")
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/pageList")
    @ApiOperation(value="查询用户分页数据", notes = "查询用户分页数据")
    public ResponseResult<PageInfo> findAll(
            @RequestBody  User user,
            int pageNum,
            int pageSize){
        String whereSql = "%"+user.getUsername()+"%";
        PageInfo<User> data = userService.queryPageListByField(pageNum,pageSize,
                Sqls.custom().andLike("username",whereSql),
                "username","asc","username");
        //List<User> data = userService.pageList(user,pageNum,pageSize);
        return new ResponseResult<>(SUCCESS,data);
    }

    @PostMapping("/add")
    @ApiOperation(value="插入用户数据", notes = "插入用户数据")
    public ResponseResult<Void> add(
            @ApiParam(name="user",value="用户数据",required=true) @RequestBody User user
    ){
        //userService.add(user);
        userService.save(user);
        return new ResponseResult<>(SUCCESS);
    }

    @PostMapping("/delete")
    @ApiOperation(value="删除用户数据", notes = "删除用户数据")
    public ResponseResult<Void> delete(
            @ApiParam(name="user",value="用户数据",required=true) @RequestBody User user
    ){

        userService.deleteByWhere(user);
        return new ResponseResult<>(SUCCESS);
    }

    @PostMapping("/update")
    @ApiOperation(value="修改用户数据", notes = "修改用户数据")
    public ResponseResult<Void> update(
            @ApiParam(name="user",value="用户数据",required=true) @RequestBody User user
    ){

        userService.updateSelective(user);
        return new ResponseResult<>(SUCCESS);
    }

    @PostMapping("/updateXml")
    @ApiOperation(value="修改用户数据", notes = "修改用户数据")
    public ResponseResult<Void> updateXml(
            @ApiParam(name="user",value="用户数据",required=true) @RequestBody User user
    ){

        userService.updateUser(user);
        return new ResponseResult<>(SUCCESS);
    }

    @PostMapping("/list")
    @ApiOperation(value="查询用户数据", notes = "查询用户数据")
    public ResponseResult<List> list(
            @ApiParam(name="user",value="用户数据",required=true) @RequestBody User user
    ){

        List<User> data = userService.queryListByWhere(user);
        return new ResponseResult<>(SUCCESS,data);
    }

    @PostMapping("/signup")
    @ApiOperation(value="注册", notes = "注册")
    public ResponseResult<Void> signUp(
            @ApiParam(name="user",value="用户数据",required=true) @RequestBody User user
    ){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        userService.save(user);
        return new ResponseResult<>(SUCCESS);
    }

    

}

package com.initspringboot.vueboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.initspringboot.vueboot.dao.UserMapper;
import com.initspringboot.vueboot.entity.User;
import com.initspringboot.vueboot.service.IUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService  {
    @Autowired
    private UserMapper userMapper;


    /*@Override
    public List<User> pageList(User user,int pageNum, int pageSize) {
        *//*String sql = "select * from user where u_id = #{uId} or u_id = #{uId2}";
        Map map = new LinkedHashMap();
        map.put("sql",sql);
        map.put("uId",1);
        map.put("uId2",2);*//*
        //List<User> users = userMapper.selectAll();
        //List<User> users =userMapper.selectByRowBounds(user,new RowBounds(1,3));
        //PageHelper.startPage(pageNum,pageSize);//pageNum<=0 会查询第一页，如果 pageNum>总页数 会查询最后一页。
        //Page<User> userList = (Page<User>) userMapper.PageList(user);
        //userList.getTotal();//总条数
        //userList.size(); //每页的条数

        *//*Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andLike("username","%"+ user.getUsername() +"%");
        //userMapper.selectByExample(example);
        return userMapper.selectByExample(example);*//*
        List<User> data = queryAll();
        return data;

    }

    @Override
    public void add(User user) {
       *//* String sql = "insert into user values(#{user.uId},#{user.username},#{user.password},#{user.role})";
        Map map = new LinkedHashMap();
        map.put("sql",sql);
        map.put("user",user);*//*
        int rows = userMapper.insert(user);

        System.err.println(rows+","+user.getuId());
        if(rows == 1){
            throw new RuntimeException("新增成功");
        }


    }*/

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}

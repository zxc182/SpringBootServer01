package com.initspringboot.vueboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.initspringboot.vueboot.dao.UserMapper;
import com.initspringboot.vueboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() throws JsonProcessingException {
        //从redis中获得数据， 数据的形式json字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        //判断redis是否存在数据
        if(null == userListJson){
            //不存在，从数据库查询
            List<User> users = userMapper.selectAll();
            System.err.println(users);
            //将查询出的数据存储到redis缓存中
            //将list集合转换成json格式的字符串 使用jackSon进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.err.println("从数据库中获得数据");


        }else{
            System.err.println("从redis缓存中获得数据");
        }
        //打印
        System.err.println(userListJson);
    }
}

package com.initspringboot.vueboot;

import com.initspringboot.vueboot.dao.UserMapper;
import com.initspringboot.vueboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VuebootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        /*List<User> users = userMapper.selectAll();
        System.err.println(users);*/
    }

}

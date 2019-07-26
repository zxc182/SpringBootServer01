package com.initspringboot.vueboot.entity;

import com.initspringboot.vueboot.util.UUIdGenId;
import org.springframework.data.annotation.Id;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

@Table
public class User {

    @Id
    @KeySql(genId = UUIdGenId.class) //生成uuid
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "select uuid") //auto 让程序生成 获取主键
    private String uId;
    private String username;
    private String password;
    @Transient
    private String age;
    private String role;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

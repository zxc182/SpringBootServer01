package com.initspringboot.vueboot.entity;

import com.initspringboot.vueboot.util.UUIdGenId;
import tk.mybatis.mapper.annotation.KeySql;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @KeySql(genId = UUIdGenId.class) //生成uuid
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "select uuid") //auto 让程序生成 获取主键
    @Column(name = "u_id")
    private String uId;
    private String username;
    private String password;
    @Transient
    private String age;
    private String role;
    private String salt;
    

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

   

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", password=" + password + ", role=" + role + ", salt=" + salt + ", uId=" + uId
                + ", username=" + username + "]";
    }

    
}

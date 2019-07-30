package com.initspringboot.vueboot.config;

import java.util.ArrayList;
import java.util.List;

import com.initspringboot.vueboot.entity.User;
import com.initspringboot.vueboot.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(username);
        User user2 = userService.queryOne(user);

        if(user2 == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        System.err.println("username is " + username + ", " + user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
	}
    

    
}
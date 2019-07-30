package com.initspringboot.vueboot.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.initspringboot.vueboot.entity.User;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 *  attemptAuthentication：接收并解析用户凭证。 
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager; 

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 接收并解析用户凭证
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {

            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            
            return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        String token = Jwts.builder()
            .setSubject(((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
            .compact();
        ((HttpServletResponse) request).addHeader("Authorization", "Bearer " + token);
        //super.successfulAuthentication(request, response, chain, authResult);
    }

}
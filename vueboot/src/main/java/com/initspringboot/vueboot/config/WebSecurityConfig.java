package com.initspringboot.vueboot.config;

import com.initspringboot.vueboot.service.IUserService;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * security核心配置类
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 * 
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 表示开启全局方法注解，可在指定方法上面添加注解指定权限，需含有指定权限才可调用(基于表达式的权限控制)\
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService ;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();// 关闭防跨域攻击功能

        // 请根据自身业务进行扩展

        http.csrf().disable() // 关闭防跨域攻击功能
                .authorizeRequests()
                .antMatchers("/users/signup","/login").permitAll()// 指定用户可以访问的url模式
                .antMatchers("/v2/api-docs",//swagger api json
                "/swagger-resources/configuration/ui",//用来获取支持的动作
                "/swagger-resources",//用来获取api-docs的URL
                "/swagger-resources/configuration/security",//安全选择
                "/swagger-ui.html",
                "/webjars/springfox-swagger-ui/**"
                ).permitAll()
                //.antMatchers("/admin/**").hasRole("ADMIN") // 以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") // 任何以"/db/" 开头的URL需要用户同时具有
                                                                                     // "ROLE_ADMIN" 和 "ROLE_DBA"
                .anyRequest().authenticated() // 尚未匹配的任何URL要求用户进行身份验证

                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))

                //.and().logout()// 提供注销支持，使用WebSecurityConfigurerAdapter会自动被应用。
                //.logoutUrl("/my/logout")// 设置触发注销操作的URL (默认是/logout). 如果CSRF内启用（默认是启用的）的话这个请求的方式被限定为POST
                //.logoutSuccessUrl("/my/index")// 注销之后跳转的URL。默认是/login?logout
                // .logoutSuccessHandler(logoutSuccessHandler)//让你设置定制的
                // LogoutSuccessHandler。如果指定了这个选项那么logoutSuccessUrl()的设置会被忽略
                //.invalidateHttpSession(true)// 指定是否在注销时让HttpSession无效。 默认设置为 true。
                // .addLogoutHandler(logoutHandler)//添加一个LogoutHandler.默认SecurityContextLogoutHandler会被添加为最后一个LogoutHandler
                // .deleteCookies(cookieNamesToClear)//允许指定在注销成功时将移除的cookie
                // 为了定制注销功能，你可以添加 LogoutHandler和LogoutSuccessHandler的实现

                .formLogin();
                // .loginPage("/login")/*指定登录页的路径*/
                //.successHandler(authenticationSuccessHandler) // 登录成功处理
                //.failureHandler(authenticationFailureHandler) // 登录失败处理
                //.permitAll(); //permitAll()方法允许基于表单登录的所有的URL的所有用户的访问。
        //http.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // 无权访问的json格式数据
        //http.addFilterBefore(JwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);// jwt filter


    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 代码省略...
        /* auth.inMemoryAuthentication()// 内存中身份验证
                .withUser("user").password("password").roles("USER").and()// 配置用户名密码
                .withUser("admin").password("password").roles("USER", "ADMIN"); */
        /*
         * auth .jdbcAuthentication() //jdbc验证 .dataSource(dataSource)
         * .withDefaultSchema() .withUser("root").password("root").roles("USER").and()
         * .withUser("admin").password("password").roles("USER", "ADMIN"); auth
         * .ldapAuthentication() //LDAP 验证 .userDnPatterns("uid={0},ou=people")
         * .groupSearchBase("ou=groups");
         */

        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    

    /* @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");// remove the ROLE_ prefix 刪除role_

    } */

}

//package com.initspringboot.vueboot.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
///**
// *
// * 创建一个springSecurityFilterChain 的Servlet的过滤器
// * 负责所有安全
// * （例如 保护应用程序的URL，验证提交的用户名和密码，重定向到登陆的表单等等）
// */
//@EnableWebSecurity
//public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()//内存中身份验证
//                    .withUser("user").password("password").roles("USER").and()//配置用户名密码
//                    .withUser("admin").password("password").roles("USER", "ADMIN");
//        /*auth
//                .jdbcAuthentication() //jdbc验证
//                    .dataSource(dataSource)
//                    .withDefaultSchema()
//                    .withUser("user").password("password").roles("USER").and()
//                    .withUser("admin").password("password").roles("USER", "ADMIN");
//        auth
//                .ldapAuthentication() //LDAP 验证
//                        .userDnPatterns("uid={0},ou=people")
//                        .groupSearchBase("ou=groups");*/
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/resources/**", "/signup", "/about").permitAll()//指定用户可以访问的url模式
//                    .antMatchers("/admin/**").hasRole("ADMIN") //以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问
//                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") //任何以"/db/" 开头的URL需要用户同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"
//                    .anyRequest().authenticated() //尚未匹配的任何URL要求用户进行身份验证
//                    .and()
//                .logout()//提供注销支持，使用WebSecurityConfigurerAdapter会自动被应用。
//                    .logoutUrl("/my/logout")//设置触发注销操作的URL (默认是/logout). 如果CSRF内启用（默认是启用的）的话这个请求的方式被限定为POST
//                    .logoutSuccessUrl("/my/index")//注销之后跳转的URL。默认是/login?logout
//                    //.logoutSuccessHandler(logoutSuccessHandler)//让你设置定制的 LogoutSuccessHandler。如果指定了这个选项那么logoutSuccessUrl()的设置会被忽略
//                    .invalidateHttpSession(true)//指定是否在注销时让HttpSession无效。 默认设置为 true。
//                    //.addLogoutHandler(logoutHandler)//添加一个LogoutHandler.默认SecurityContextLogoutHandler会被添加为最后一个LogoutHandler
//                    //.deleteCookies(cookieNamesToClear)//允许指定在注销成功时将移除的cookie
//                    .and()
//                    //为了定制注销功能，你可以添加 LogoutHandler和LogoutSuccessHandler的实现
//                .formLogin()
//                   //.loginPage("/login")/*指定登录页的路径*/
//                   .permitAll();
//                //formLogin().permitAll()方法允许基于表单登录的所有的URL的所有用户的访问。
//
//    }
//
//
//
//
//}

package com.vueboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 在你的应用程序中创建一个springSecurityFilterChain 的Servlet的过滤器
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);

        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http
                /*验证请求*/
                .authorizeRequests()//确保我们应用中的所有请求都需要用户被认证
                    .antMatchers("/resources/**").permitAll() //指定任何用户都可以通过访问的多个URL模式
                    .antMatchers("/admin/**").hasRole("ADMIN") //以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问
                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") //任何以"/db/" 开头的URL需要用户同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"
                    .anyRequest().authenticated() //尚未匹配的任何URL要求用户进行身份验证
                    .and()
                .formLogin()//允许用户进行基于表单的认证
                    .loginPage("/login") //指定登录页的路径
                    .permitAll() //允许基于表单登录的所有的URL的所有用户的访问。
                    .and()
                .httpBasic() //允许用户使用HTTP基于验证进行认证
                    .and()
                /*处理登出*/
                .logout() //提供注销支持
                    .logoutUrl("/my/logout") //设置触发注销操作的URL (默认是/logout). 如果CSRF内启用（默认是启用的）的话这个请求的方式被限定为POST
                    .logoutSuccessUrl("/my/index")//注销之后跳转的URL
                    //.logoutSuccessHandler(logoutSuccessHandler) //让你设置定制的 LogoutSuccessHandler。如果指定了这个选项那么logoutSuccessUrl()的设置会被忽略
                    .invalidateHttpSession(true) //指定是否在注销时让HttpSession无效。 默认设置为 true。
                    //.addLogoutHandler(logoutHandler)//添加一个LogoutHandler.默认SecurityContextLogoutHandler会被添加为最后一个LogoutHandler。
                    //.deleteCookies(cookieNamesToClear) //允许指定在注销成功时将移除的cookie
                    .and();
    }
}

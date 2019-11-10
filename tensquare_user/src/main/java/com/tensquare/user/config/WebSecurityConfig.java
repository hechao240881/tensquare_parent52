package com.tensquare.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//WebSecurityConfigurerAdapter 空方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * authorizeRequests（授权） 所有 security 全注解配置实现的开端，表示开始说明需要的权限
         * 需要的权限分两部分，第一部分是拦截的路径，第二部分是访问该路径需要的权限
         * antMatchers 表示拦截什么路径， permitAll 任何权限都可以访问 直接放行所有
         * anyRequest() 任何的请求，authenticated 认证后才能访问
         * and().csrf().disable() 固定写法，表示csrf 拦截失效，所有内部意外的请求都认为是在攻击当前程序
         */
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}

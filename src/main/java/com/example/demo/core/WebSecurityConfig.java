package com.example.demo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/8
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService() { // 注册UserDetailsService 的bean
        return new UserDetailServiceImpl();
    }
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    @Override
    //重写configure(HttpSecurity http)的方法，这里面来自定义自己的拦截方法和业务逻辑
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
//                .antMatchers("/js/**","/css/**","/images/*","/fonts/**","/**/*.png","/**/*.jpg").permitAll()
                .antMatchers("/login").permitAll()
//                .antMatchers("/","/login","/signin").permitAll()未登录时这几个页面都可以进（未拦截）
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe().rememberMeParameter("remember-me") //其实默认就是remember-me，这里可以指定更换
                .and()
                .logout()
                .logoutUrl("/logout")
//                .logoutSuccessUrl("/logout")  //退出登录，好奇怪，把这个放出来，就一直在确认退出那个页面
                .permitAll();//这是啥意思啊，退出后其他页面就访问不了啦，那这个permitAll还有啥意义呀，而且上面那个url也根本不是退出成功的页面啊，退出是成功了但是一个报错页
                /*.and()
                .csrf().disable();*/

    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
    }
}
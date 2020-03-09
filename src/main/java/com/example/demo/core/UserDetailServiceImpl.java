package com.example.demo.core;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/8
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.selectUserByName(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        /*HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("sessusername",username);*/
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (Role role:user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        System.out.println(user.getUserName()+authorities.toString());
        User user1 = new User(user.getUserName(), user.getUserPassword(), authorities);
        System.out.println("即将成功登陆");
        return user1;
    }
}


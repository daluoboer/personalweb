package com.example.demo.controller;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/6
 */

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "/logout";
    }

    @RequestMapping("/goRegister")
    public String goRegister(){
        return "/register";
    }

    @RequestMapping("/register")
    public String register(
            Model model,
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        model.addAttribute("message","注册成功,请通过用户名登录");
        model.addAttribute("mm","you succeed!");
        System.out.println("注册ing...");
        UserEntity entity = new UserEntity();
        entity.setUserName(username);
        entity.setUserPassword(password);
        userService.insertUser(entity);
        System.out.println(username + "注册成功");
        return "redirect:/login";
    }
}

package com.example.demo.controller;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/6
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/logout")
    public String logout(){
        return "/logout";
    }
}

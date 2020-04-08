package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/6
 */

@Controller
public class BlogController {
    @RequestMapping("/")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "goProgramming")
    public String goProgramming() {
        return "programmerLife";
    }

    @RequestMapping(value = "goLove")
    public String goLove() {
        return "myLove";
    }

    @RequestMapping(value = "goBoring")
    public String goBoring() {
        return "boring";
    }

    @RequestMapping(value = "goChatterbox")
    public String goChatterbox() {
        return "chatterbox";
    }

    @RequestMapping(value = "goBlog")
    public String goBlog() {
        return "blog";
    }
}

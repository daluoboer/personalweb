package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getTest(){
        return "redirect:http://www.baidu.com";
    }

    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public String getTes3(){
        return "redirect:index";
    }

    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public String getTest1() { return "forward:index"; }

    /*只有这样不行！第二个是没有问题滴
    * 请求转发只能发给内部，
    * 重定向都行~*/
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public String getTest2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        System.out.println(response);
        return "forward:http://www.baidu.com";
    }


}

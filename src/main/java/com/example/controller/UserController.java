package com.example.controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/5
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getTest(
            @RequestParam("id") Long id
    ){
        UserEntity userEntity = userService.selectUserById(id);
        return userEntity== null ? null : userEntity.toString();
    }
}

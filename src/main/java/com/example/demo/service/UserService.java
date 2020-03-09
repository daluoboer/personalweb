package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserEntityExample;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/5
 */
public interface UserService {
    UserEntity selectUserById(Long id);

    UserEntity selectUserByName(String name);

    UserEntity selectUserByExample(UserEntityExample example);
}

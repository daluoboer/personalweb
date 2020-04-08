package com.example.service;

import com.example.entity.UserEntity;
import com.example.entity.UserEntityExample;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/5
 */
public interface UserService {
    UserEntity selectUserById(Long id);

    UserEntity selectUserByName(String name);

    UserEntity selectUserByExample(UserEntityExample example);

    Integer insertUser(UserEntity entity);
}

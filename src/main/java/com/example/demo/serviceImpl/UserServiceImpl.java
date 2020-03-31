package com.example.demo.serviceImpl;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserEntityExample;
import com.example.demo.mapper.UserEntityMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/5
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public UserEntity selectUserById(Long id) {
        return userEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserEntity selectUserByExample(UserEntityExample example) {
        List<UserEntity> userEntities = userEntityMapper.selectByExample(example);
        if (userEntities.isEmpty())
            return null;
        return userEntities.get(0);
    }

//    @Transactional
    @Transactional
    @Override
    public UserEntity selectUserByName(String name) {
        UserEntityExample example = new UserEntityExample();
        UserEntityExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(name);
        return selectUserByExample(example);
    }

    @Override
    public Integer insertUser(UserEntity entity) {
        return userEntityMapper.insertSelective(entity);
    }
}

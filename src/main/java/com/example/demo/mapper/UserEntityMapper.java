package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserEntityMapper {
    int countByExample(UserEntityExample example);

    int deleteByExample(UserEntityExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityExample example);

    UserEntity selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}
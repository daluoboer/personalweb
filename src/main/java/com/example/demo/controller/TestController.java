package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getTest(){
        return "test";
    }
}

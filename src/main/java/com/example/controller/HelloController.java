package com.example.controller;

import com.example.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //主要在我们的接口中，返回值存在实体类，就会被扫描到swagger中
    @PostMapping("/getUser")
    public User getUser(){
        return new User();
    }

    @ApiOperation("获取用户信息")//ApiOperation，放在接口上，不是类上
    @GetMapping("/getInfo")
    public String getInfo(@ApiParam("用户名") String name){//@ApiParam 作用在参数上
        return "hello"+name;
    }
}

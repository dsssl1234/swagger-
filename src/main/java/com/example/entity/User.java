package com.example.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api("用户实体类")
public class User {
    @ApiModelProperty("用户名")//作用在字段啊，注意如果是私有属性，需要get、set方法
    public String name;
}

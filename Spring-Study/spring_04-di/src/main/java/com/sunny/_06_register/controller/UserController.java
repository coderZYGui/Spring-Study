package com.sunny._06_register.controller;

import com.sunny._06_register.domain.User;
import com.sunny._06_register.service.UserService;
import lombok.Setter;

// 模拟Struct2的Action / SpringMVC的Controller
public class UserController {

    @Setter
    private UserService service;

    public String register(){
        System.out.println("注册请求");
        service.register(new User("朝阳", 100));
        return "success";
    }
}

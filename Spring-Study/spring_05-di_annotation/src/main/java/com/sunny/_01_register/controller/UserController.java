package com.sunny._01_register.controller;

import com.sunny._01_register.service.UserService;
import com.sunny._01_register.domain.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 模拟Struct2的Action / SpringMVC的Controller
@Controller
public class UserController {

    //@Setter
    @Autowired
    private UserService service;

    public String register(){
        System.out.println("注册请求");
        service.register(new User("阳仔", 99));
        return "success";
    }
}

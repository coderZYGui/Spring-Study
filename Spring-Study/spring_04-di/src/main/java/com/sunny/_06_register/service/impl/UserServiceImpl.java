package com.sunny._06_register.service.impl;

import com.sunny._06_register.dao.UserDao;
import com.sunny._06_register.domain.User;
import com.sunny._06_register.service.UserService;
import lombok.Setter;

public class UserServiceImpl implements UserService {

    @Setter
    private UserDao dao;

    public void register(User u) {
        System.out.println("注册方法");
        dao.save(u);
    }
}

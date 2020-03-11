package com.sunny._01_register.service.impl;

import com.sunny._01_register.domain.User;
import com.sunny._01_register.service.UserService;
import com.sunny._01_register.dao.UserDao;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements UserService {

    //@Setter
    @Autowired // 是按类型去找
    private UserDao dao;

    public void register(User u) {
        System.out.println("注册方法");
        dao.save(u);
    }
}

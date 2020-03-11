package com.sunny._01_static_proxy.service;

import com.sunny._01_static_proxy.dao.UserDao;

public class UserServiceImpl implements UserService{

//    private UserDao dao = new UserDaoImpl();
//    private UserDao dao = new UserDaoMysqlImpl();

    private UserDao dao;

    // 利用set进行动态实现值的注入!
    public void setUserDao(UserDao dao){
        this.dao = dao;
    }

    public void getUser() {
        dao.getUser();
    }
}

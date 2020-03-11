package com.sunny._01_static_proxy.dao;

public class UserDaoMysqlImpl implements UserDao{
    public void getUser() {
        System.out.println("使用MySQL!");
    }
}

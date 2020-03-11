package com.sunny._06_register.dao;

import com.sunny._06_register.domain.User;

public interface UserDao {
    // 保存用户信息
    void save(User u);
}

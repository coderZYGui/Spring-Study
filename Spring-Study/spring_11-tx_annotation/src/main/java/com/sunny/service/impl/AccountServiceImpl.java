package com.sunny.service.impl;

import com.sunny.dao.AccountDao;
import com.sunny.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 可以设置属性
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;

    public void trans(Long outId, Long inId, int money) {
        dao.transOut(outId, money);
        int a = 1 / 0; // 抛出异常
        dao.transIn(inId, money);
    }

    @Transactional(readOnly = true)
    public void queryAll(){
        //TODO
    }
}

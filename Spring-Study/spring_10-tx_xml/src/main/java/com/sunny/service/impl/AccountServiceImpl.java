package com.sunny.service.impl;

import com.sunny.dao.AccountDao;
import com.sunny.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao dao;

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }

    public void trans(Long outId, Long inId, int money) {
        dao.transOut(outId, money);
        int a = 1 / 0; // 抛出异常
        dao.transIn(inId, money);
    }
}

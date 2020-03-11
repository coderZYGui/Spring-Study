package com.sunny.dao;

public interface AccountDao {

    /**
     * 从指定账户转出多少钱
     * @param outId
     * @param money
     */
    void transOut(Long outId, int money);

    /**
     * 从指定账户转入多少钱
     * @param inId
     * @param money
     */
    void transIn(Long inId, int money);
}

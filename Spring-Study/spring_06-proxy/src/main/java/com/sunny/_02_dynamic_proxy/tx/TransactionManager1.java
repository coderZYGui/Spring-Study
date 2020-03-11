package com.sunny._02_dynamic_proxy.tx;

public class TransactionManager1 {
    public void begin(){
        System.out.println("开启事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }

    public void rollback(){
        System.out.println("回滚事务");
    }
}

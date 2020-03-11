package com.sunny._01_static_proxy.proxy;

import com.sunny._01_static_proxy.domain.Employee;
import com.sunny._01_static_proxy.service.EmployeeService;
import com.sunny._01_static_proxy.tx.TransactionManager;

public class EmployeeServiceProxy implements EmployeeService {

    private TransactionManager tx; // 事务管理器
    private EmployeeService target; // 真实对象/委托对象

    public void setTarget(EmployeeService target) {
        this.target = target;
    }

    public void setTx(TransactionManager tx) {
        this.tx = tx;
    }

    public void save(Employee emp) {
        // 开启事务
        tx.begin();
        try {
            target.save(emp);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    public void update(Employee emp) {
        tx.begin();
        try {
            target.update(emp);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}

package com.sunny._02_dynamic_proxy.service.impl;

import com.sunny.dao.EmployeeDao1;
import com.sunny.domain.Employee1;
import com.sunny._02_dynamic_proxy.service.EmployeeService1;

public class EmployeeServiceImpl1 implements EmployeeService1 {

    private EmployeeDao1 dao1;

    public void setDao1(EmployeeDao1 dao1) {
        this.dao1 = dao1;
    }

    public void save(Employee1 emp) {
        dao1.save(emp);
        System.out.println("保存成功");
    }

    public void update(Employee1 emp) {
        dao1.update(emp);
        throw new RuntimeException("故意出错");
    }

    public void delete(Long l) {
        System.out.println("删除成功");
    }

    public void queryAll() {
        System.out.println("查询全部");
    }
}

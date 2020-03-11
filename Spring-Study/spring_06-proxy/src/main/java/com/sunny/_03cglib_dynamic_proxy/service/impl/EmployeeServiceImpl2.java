package com.sunny._03cglib_dynamic_proxy.service.impl;

import com.sunny._03cglib_dynamic_proxy.dao.EmployeeDao2;
import com.sunny._03cglib_dynamic_proxy.domain.Employee2;

public class EmployeeServiceImpl2 {

    private EmployeeDao2 dao;

    public void setDao(EmployeeDao2 dao) {
        this.dao = dao;
    }

    public void save(Employee2 emp) {
        dao.save(emp);
        System.out.println("保存成功");
    }

    public void update(Employee2 emp) {
        dao.update(emp);
        throw new RuntimeException("故意出错");
    }
}

package com.sunny._04cglib_methodinterceptor.service.impl;

import com.sunny._04cglib_methodinterceptor.dao.EmployeeDao3;
import com.sunny._04cglib_methodinterceptor.domain.Employee3;

public class EmployeeServiceImpl3 {

    private EmployeeDao3 dao;

    public void setDao(EmployeeDao3 dao) {
        this.dao = dao;
    }

    public void save(Employee3 emp) {
        dao.save(emp);
        System.out.println("保存成功");
    }

    public void update(Employee3 emp) {
        dao.update(emp);
        throw new RuntimeException("故意出错");
    }
}

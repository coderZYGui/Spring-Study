package com.sunny._01_static_proxy.service.impl;

import com.sunny._01_static_proxy.dao.EmployeeDao;
import com.sunny._01_static_proxy.domain.Employee;
import com.sunny._01_static_proxy.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao dao;

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }

    public void save(Employee emp) {
        dao.save(emp);
        System.out.println("保存成功");
    }

    public void update(Employee emp) {
        dao.update(emp);
        throw new RuntimeException("故意出错");
    }
}

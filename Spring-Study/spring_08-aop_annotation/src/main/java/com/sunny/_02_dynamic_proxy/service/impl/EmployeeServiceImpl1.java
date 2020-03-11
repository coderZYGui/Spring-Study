package com.sunny._02_dynamic_proxy.service.impl;

import com.sunny.dao.EmployeeDao1;
import com.sunny.domain.Employee1;
import com.sunny._02_dynamic_proxy.service.EmployeeService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl1 implements EmployeeService1 {

    @Autowired
    private EmployeeDao1 dao1;


    public void save(Employee1 emp) {
        dao1.save(emp);
        System.out.println("保存成功");
    }

    public void update(Employee1 emp) {
        dao1.update(emp);
        throw new RuntimeException("故意出错");
    }

}

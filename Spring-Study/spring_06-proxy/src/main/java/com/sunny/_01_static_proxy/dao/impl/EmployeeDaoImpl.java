package com.sunny._01_static_proxy.dao.impl;

import com.sunny._01_static_proxy.dao.EmployeeDao;
import com.sunny._01_static_proxy.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
    public void save(Employee emp) {
        System.out.println("保存员工");
    }

    public void update(Employee emp) {
        System.out.println("修改员工信息");;
    }
}

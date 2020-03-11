package com.sunny.dao.impl;

import com.sunny.dao.EmployeeDao1;
import com.sunny.domain.Employee1;

public class EmployeeDaoImpl1 implements EmployeeDao1 {
    public void save(Employee1 emp) {
        System.out.println("保存员工");
    }

    public void update(Employee1 emp) {
        System.out.println("修改员工信息");;
    }
}

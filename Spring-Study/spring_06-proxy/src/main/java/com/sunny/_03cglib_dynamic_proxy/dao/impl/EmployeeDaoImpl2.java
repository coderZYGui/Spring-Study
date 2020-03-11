package com.sunny._03cglib_dynamic_proxy.dao.impl;

import com.sunny._03cglib_dynamic_proxy.dao.EmployeeDao2;
import com.sunny._03cglib_dynamic_proxy.domain.Employee2;

public class EmployeeDaoImpl2 implements EmployeeDao2 {
    public void save(Employee2 emp) {
        System.out.println("保存员工");
    }

    public void update(Employee2 emp) {
        System.out.println("修改员工信息");;
    }
}

package com.sunny._04cglib_methodinterceptor.dao.impl;

import com.sunny._04cglib_methodinterceptor.dao.EmployeeDao3;
import com.sunny._04cglib_methodinterceptor.domain.Employee3;

public class EmployeeDaoImpl3 implements EmployeeDao3 {
    public void save(Employee3 emp) {
        System.out.println("保存员工");
    }

    public void update(Employee3 emp) {
        System.out.println("修改员工信息");;
    }
}

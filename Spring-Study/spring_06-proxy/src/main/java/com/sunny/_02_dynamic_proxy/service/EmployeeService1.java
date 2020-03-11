package com.sunny._02_dynamic_proxy.service;

import com.sunny.domain.Employee1;

public interface EmployeeService1 {
    void save(Employee1 emp);

    void update(Employee1 emp);

    // 测试增加功能不需要对增强类做操作
    void delete(Long l);

    // JDK动态反射,最小单位是类,类中的方法都会被拦截
    void queryAll();
}

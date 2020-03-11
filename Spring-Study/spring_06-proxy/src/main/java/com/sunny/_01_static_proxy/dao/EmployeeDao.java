package com.sunny._01_static_proxy.dao;

import com.sunny._01_static_proxy.domain.Employee;

public interface EmployeeDao {
    void save(Employee emp);
    void update(Employee emp);
}

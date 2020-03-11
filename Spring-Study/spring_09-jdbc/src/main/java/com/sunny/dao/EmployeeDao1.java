package com.sunny.dao;

import com.sunny.domain.Employee1;

import java.util.List;

public interface EmployeeDao1 {
    void save(Employee1 emp);

    void update(Employee1 emp);

    void delete(Long id);

    Employee1 get(Long id);

    List<Employee1> listAll();
}

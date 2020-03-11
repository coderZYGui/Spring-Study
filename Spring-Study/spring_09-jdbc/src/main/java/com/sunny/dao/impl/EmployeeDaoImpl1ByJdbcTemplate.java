package com.sunny.dao.impl;

import com.sunny.dao.EmployeeDao1;
import com.sunny.domain.Employee1;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDaoImpl1ByJdbcTemplate extends JdbcDaoSupport implements EmployeeDao1 {

    public void save(Employee1 emp) {
        String sql = "INSERT INTO employee (name, age) VALUES (?, ?)";
        super.getJdbcTemplate().update(sql, emp.getName(), emp.getAge());
    }

    public void update(Employee1 emp) {
        String sql = "UPDATE employee SET name = ?, age = ? WHERE id = ?";
        super.getJdbcTemplate().update(sql, emp.getName(), emp.getAge(), emp.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE from employee WHERE id = ?";
        super.getJdbcTemplate().update(sql, id);
    }

    public Employee1 get(Long id) {

        List<Employee1> list = super.getJdbcTemplate().query("SELECT id, name, age FROM employee WHERE id = ?", new Object[]{id},
                new RowMapper<Employee1>() {
                    public Employee1 mapRow(ResultSet resultSet, int i) throws SQLException {
                        Employee1 emp = new Employee1();
                        emp.setId(resultSet.getLong("id"));
                        emp.setName(resultSet.getString("name"));
                        emp.setAge(resultSet.getInt("age"));
                        return emp;
                    }
                });
        return list.size() == 1 ? list.get(0) : null;

        /*Employee1 employee1 = super.getJdbcTemplate().queryForObject("SELECT id, name, age FROM employee WHERE id = ?",
                new Object[]{id},new RowMapper<Employee1>() {
            public Employee1 mapRow(ResultSet rs, int i) throws SQLException {
                Employee1 emp = new Employee1();
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                return emp;
            }
        });
        return employee1;*/
    }

    public List<Employee1> listAll() {
        return super.getJdbcTemplate().query("SELECT id, name, age FROM employee", new RowMapper<Employee1>() {
            // 把每一行的结果集映射成一个Employee对象
            public Employee1 mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee1 emp = new Employee1();
                emp.setId(resultSet.getLong("id"));
                emp.setName(resultSet.getString("name"));
                emp.setAge(resultSet.getInt("age"));
                return emp;
            }
        });
    }
}

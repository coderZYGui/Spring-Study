package com.sunny.dao.impl;

import com.sunny.dao.EmployeeDao1;
import com.sunny.domain.Employee1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDaoImpl1 implements EmployeeDao1 {

    private JdbcTemplate jdbcTemplate;

    // 属性: dataSource
    public void setDataSourse(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @SuppressWarnings("unchecked")
    public void save(Employee1 emp) {
        String sql = "INSERT INTO employee (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, emp.getName(), emp.getAge());

        /*
        // 包含了通过名称占位符的模板方法,简化开发;适合?比较多的情况
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
        namedParameterJdbcTemplate.update("INSERT INTO employee (name,age) VALUES (:ename,:eage)", new HashMap(){{
            this.put("ename", emp.getName());
            this.put("eage", emp.getAge());
        }});*/
    }

    public void update(Employee1 emp) {
        String sql = "UPDATE employee SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, emp.getName(), emp.getAge(), emp.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE from employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Employee1 get(Long id) {

        List<Employee1> list = jdbcTemplate.query("SELECT id, name, age FROM employee WHERE id = ?", new Object[]{id},
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

        /*Employee1 employee1 = jdbcTemplate.queryForObject("SELECT id, name, age FROM employee WHERE id = ?",
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
        return jdbcTemplate.query("SELECT id, name, age FROM employee", new RowMapper<Employee1>() {
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

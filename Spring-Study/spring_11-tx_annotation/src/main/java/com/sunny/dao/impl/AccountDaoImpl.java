package com.sunny.dao.impl;

import com.sunny.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public void transOut(Long outId, int money) {
        String sql = "UPDATE account SET balance = balance - ? WHERE id = ?";
        jdbcTemplate.update(sql, money, outId);
    }

    public void transIn(Long inId, int money) {
        String sql = "UPDATE account SET balance = balance + ? WHERE id = ?";
        jdbcTemplate.update(sql, money, inId);
    }
}

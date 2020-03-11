package com.sunny._01_register.dao.impl;

import com.sunny._01_register.domain.User;
import com.sunny._01_register.dao.UserDao;
import lombok.Cleanup;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class UserDaoImpl implements UserDao {

    //@Setter
    @Autowired
    private DataSource dataSource;

    @SneakyThrows
    public void save(User u) {
        System.out.println("保存操作");
        @Cleanup
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO user(name ,age) VALUES(?,?)";
        @Cleanup
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, u.getName());
        ps.setInt(2, u.getAge());
        ps.executeUpdate();
    }
}

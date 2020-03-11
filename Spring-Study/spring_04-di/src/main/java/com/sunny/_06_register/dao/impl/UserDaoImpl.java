package com.sunny._06_register.dao.impl;

import com.sunny._06_register.dao.UserDao;
import com.sunny._06_register.domain.User;
import lombok.Cleanup;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {

    @Setter
    private DataSource dataSource;

    @SneakyThrows // 偷偷抛出已检查的异常
    public void save(User u) {
        System.out.println("保存操作");
        @Cleanup // 处理资源关闭
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO user(name ,age) VALUES(?,?)";
        @Cleanup
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, u.getName());
        ps.setInt(2, u.getAge());
        ps.executeUpdate();
    }
}

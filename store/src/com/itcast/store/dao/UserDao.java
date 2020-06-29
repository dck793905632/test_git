package com.itcast.store.dao;

import com.itcast.store.domain.User;

import java.sql.SQLException;

public interface UserDao {
    //用户注册
    void registUser(User user) throws SQLException;
    //用户激活
    User userActive(String code) throws SQLException;
    //激活后更改用户状态
    void updateUser(User user) throws SQLException;
    //用户登录
    User loginUser(User user) throws SQLException;
}

package com.itcast.store.service;

import com.itcast.store.domain.User;

import java.sql.SQLException;
import java.util.Map;

public interface UserService {
    //用户注册
    void registUser(User user) throws SQLException;
    //用户激活
    boolean userActive(String code) throws SQLException;
    //用户登录
    User loginUser(User user) throws SQLException;
}

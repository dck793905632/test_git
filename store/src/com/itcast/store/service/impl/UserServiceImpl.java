package com.itcast.store.service.impl;

import com.itcast.store.dao.UserDao;
import com.itcast.store.dao.impl.UserDaoImpl;
import com.itcast.store.domain.User;
import com.itcast.store.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public void registUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.registUser(user);
    }

    @Override
    public boolean userActive(String code) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.userActive(code);
        if(null!=user){
            user.setState(1);
            user.setCode(null);
            userDao.updateUser(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User loginUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user1 = userDao.loginUser(user);
        if(null==user1){
            throw new RuntimeException("密码不正确，请重新输入！");
        }else if(user1.getState()==0){
            throw new RuntimeException("账户未激活，请重新激活！");
        }else {
            return user1;
        }
    }
}

package com.itcast.store.dao.impl;

import com.itcast.store.dao.UserDao;
import com.itcast.store.domain.User;
import com.itcast.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public void registUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?)";
        Object[] parms ={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
                 user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()} ;
        queryRunner.update(sql,parms);
    }

    @Override
    public User userActive(String code) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="SELECT * FROM user where code = ?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
        return user;

    }

    @Override
    public void updateUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
        Object[] parms ={user.getUsername(),user.getPassword(),user.getName(),
                 user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode(),user.getUid()} ;
        queryRunner.update(sql,parms);

    }

    @Override
    public User loginUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username=? and password =?";
        User user1 = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
        return user1;
    }
}

package com.itcast.store.dao.impl;

import com.itcast.store.dao.CategoryDao;
import com.itcast.store.domain.Category;
import com.itcast.store.utils.JDBCUtils;
import com.itcast.store.utils.UUIDUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> getAllCats() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category";
        return queryRunner.query(sql,new BeanListHandler<Category>(Category.class));

    }

    @Override
    public void addCategory(String cid,String cname) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO category VALUES (?, ?)";
        queryRunner.update(sql,cid,cname);
    }

    @Override
    public Category findCateByCid(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category where cid = ?";
        return queryRunner.query(sql,new BeanHandler<Category>(Category.class),cid);

    }

    @Override
    public void updateCategory(String cid,String cname) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql ="UPDATE category SET cname = ? where cid =?";
        queryRunner.update(sql,cname,cid);
    }

    @Override
    public void deleteCategoryByCid(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "DELETE FROM category where cid = ?";
        queryRunner.update(sql,cid);
    }
}

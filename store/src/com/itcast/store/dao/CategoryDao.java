package com.itcast.store.dao;

import com.itcast.store.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> getAllCats() throws SQLException;

    void addCategory(String cid,String cname) throws SQLException;

    Category findCateByCid(String cid) throws SQLException;

    void updateCategory(String cid,String cname) throws SQLException;

    void deleteCategoryByCid(String cid) throws SQLException;
}

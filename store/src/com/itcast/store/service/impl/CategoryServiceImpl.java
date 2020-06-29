package com.itcast.store.service.impl;

import com.itcast.store.dao.CategoryDao;
import com.itcast.store.dao.impl.CategoryDaoImpl;
import com.itcast.store.domain.Category;
import com.itcast.store.service.CategoryService;
import com.itcast.store.utils.JedisUtils;
import com.itcast.store.utils.UUIDUtils;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> getAllCats() throws SQLException {
        List<Category> list = categoryDao.getAllCats();
        return list;
    }

    @Override
    public void addCategory(String cname) throws SQLException {
        String cid = UUIDUtils.getCode();
        categoryDao.addCategory(cid,cname);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }

    @Override
    public Category findCateByCid(String cid) throws SQLException {
        Category category=categoryDao.findCateByCid(cid);
        return category;
    }

    @Override
    public void updateCategory(String cid,String cname) throws SQLException {
        categoryDao.updateCategory(cid,cname);
    }

    @Override
    public void deleteCategoryByCid(String cid) throws SQLException {
        categoryDao.deleteCategoryByCid(cid);
    }
}

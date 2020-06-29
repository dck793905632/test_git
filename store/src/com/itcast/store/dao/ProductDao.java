package com.itcast.store.dao;

import com.itcast.store.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findNews() throws SQLException;

    List<Product> findHots() throws SQLException;

    Product findProByPid(String pid) throws SQLException;

    int findProductCount(String cid)throws SQLException;

    List findProductsByCidWithPage(String cid, int startIndex, int pageSize)throws SQLException;

    int findTotakProduct()throws SQLException;

    List<Product> findAllProductsWithPage(int startIndex, int pageSize)throws SQLException;

    int findTotakProduct1()throws SQLException;

    List<Product> findAllPushDownProWithPage(int startIndex, int pageSize)throws SQLException;

    void saveProduct(Product product) throws SQLException;

    void updatePflag(String pid) throws SQLException;

    void updatePflagUp(String pid) throws SQLException;

    void updateProductByPid(Product product) throws SQLException;
}

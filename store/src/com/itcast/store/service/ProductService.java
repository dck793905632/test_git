package com.itcast.store.service;

import com.itcast.store.domain.PageModel;
import com.itcast.store.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findNews() throws SQLException;

    List<Product> findHots() throws SQLException;

    Product findProByPid(String pid) throws SQLException;

    PageModel findProductsByCidWithPage(String cid, int currNum) throws SQLException;

    PageModel findAllProductsWithPage(int curNum) throws SQLException;

    PageModel findAllPushDownProWithPage(int curNum) throws SQLException;

    void saveProduct(Product product) throws SQLException;

    void updatePflag(String pid) throws SQLException;

    void updatePflagUp(String pid) throws SQLException;

    void updateProductByPid(Product product) throws SQLException;
}

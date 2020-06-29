package com.itcast.store.dao.impl;

import com.itcast.store.dao.ProductDao;
import com.itcast.store.domain.PageModel;
import com.itcast.store.domain.Product;
import com.itcast.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    QueryRunner queryRunner =new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Product> findNews() throws SQLException {
        String sql ="SELECT * from product where pflag=0 ORDER BY pdate LIMIT 0 , 9";
        List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        return list;
    }

    @Override
    public List<Product> findHots() throws SQLException {
        String sql ="SELECT * from product where pflag=0 and is_hot=1 ORDER BY pdate LIMIT 0, 9";
        List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        return list;
    }

    @Override
    public Product findProByPid(String pid) throws SQLException {
        String sql = "select * from product where pid = ?";
        return queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);

    }

    @Override
    public int findProductCount(String cid) throws SQLException {
        String sql = "SELECT count(*) FROM product where cid = ?";
        Long num=(Long)queryRunner.query(sql, new ScalarHandler(), cid);
        return num.intValue();
    }

    @Override
    public List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws SQLException {
        String sql = "SELECT * FROM product where cid = ? LIMIT ?,?";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),cid,startIndex,pageSize);

    }

    @Override
    public int findTotakProduct() throws SQLException {
        String sql = "select count(*)  from product where pflag=0";
        Long totalPro = (Long)queryRunner.query(sql,new ScalarHandler());
        return totalPro.intValue();
    }

    @Override
    public List<Product> findAllProductsWithPage(int startIndex, int pageSize) throws SQLException {
        String sql = "SELECT * FROM product where pflag=0 ORDER BY pdate DESC  LIMIT ? , ?";
        List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), startIndex, pageSize);
        return list;
    }

    @Override
    public int findTotakProduct1() throws SQLException {
        String sql = "select count(*)  from product where pflag=1";
        Long totalPro = (Long)queryRunner.query(sql,new ScalarHandler());
        return totalPro.intValue();

    }

    @Override
    public List<Product> findAllPushDownProWithPage(int startIndex, int pageSize) throws SQLException {
        String sql = "SELECT * FROM product where pflag=1 ORDER BY pdate DESC  LIMIT ? , ?";
        List<Product> list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),startIndex,pageSize);
        return list;
    }

    @Override
    public void saveProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?,?)";
        Object[] parms={product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price()
        ,product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid()};
        queryRunner.update(sql,parms);
    }

    @Override
    public void updatePflag(String pid) throws SQLException {
        String sql = "UPDATE product set pflag = 1 where pid =?";
        queryRunner.update(sql,pid);
    }

    @Override
    public void updatePflagUp(String pid) throws SQLException {
        String sql = "UPDATE product set pflag = 0 where pid =?";
        queryRunner.update(sql,pid);
    }

    @Override
    public void updateProductByPid(Product product) throws SQLException {
        String sql ="UPDATE product SET pname=?,market_price=?,shop_price=?,pimage=?,pdate=?," +
                "is_hot=?,pdesc=?,pflag=? ,cid=? WHERE pid = ?";
        Object[] parms= {product.getPname(),product.getMarket_price(),product.getShop_price(),
        product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag()
        ,product.getCid(),product.getPid()};
        queryRunner.update(sql,parms);
    }
}

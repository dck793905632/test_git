package com.itcast.store.service.impl;

import com.itcast.store.dao.ProductDao;
import com.itcast.store.dao.impl.ProductDaoImpl;
import com.itcast.store.domain.PageModel;
import com.itcast.store.domain.Product;
import com.itcast.store.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> findNews() throws SQLException {
        List<Product> list=productDao.findNews();
        return list;
    }
    @Override
    public List<Product> findHots() throws SQLException {
        List<Product> list=productDao.findHots();
        return list;
    }

    @Override
    public Product findProByPid(String pid) throws SQLException {
        Product product=productDao.findProByPid(pid);
        return product;
    }

    @Override
    public PageModel findProductsByCidWithPage(String cid, int currNum) throws SQLException {
        //获得总数据条数
        int totalRecords = productDao.findProductCount(cid);
        PageModel pageModel = new PageModel(currNum,totalRecords,12);
        //关联集合  SELECT * FROM product where cid = ? LIMIT ?,?
        List list=productDao.findProductsByCidWithPage(cid,pageModel.getStartIndex(),pageModel.getPageSize());
        pageModel.setList(list);
        //关联url
        pageModel.setUrl("ProductServlet?method=findProductsByCidWithPage&cid="+cid);
        return pageModel;
    }

    @Override
    public PageModel findAllProductsWithPage(int curNum) throws SQLException {
        //DAo对象
        ProductDao productDao = new ProductDaoImpl();
        //查询产品总数
        int totalRecords=productDao.findTotakProduct();
        //创建对象
        PageModel pageModel = new PageModel(curNum,totalRecords,5);
        //关联集合
        List<Product> list=productDao.findAllProductsWithPage(pageModel.getStartIndex(),pageModel.getPageSize());
        pageModel.setList(list);
        //关联url
        pageModel.setUrl("AdminProductServlet?method=findAllProductsWithPage");
        return pageModel;
    }

    @Override
    public PageModel findAllPushDownProWithPage(int curNum) throws SQLException {

        ProductDao productDao = new ProductDaoImpl();
        int totalRecords=productDao.findTotakProduct1();
        //创建对象
        PageModel pageModel = new PageModel(curNum,totalRecords,5);
        //关联集合
        List<Product> list =productDao.findAllPushDownProWithPage(pageModel.getStartIndex(),pageModel.getPageSize());
        pageModel.setList(list);
        //关联url
        pageModel.setUrl("AdminProductServlet?method=findAllPushDownProWithPage");
        return pageModel;
    }

    @Override
    public void saveProduct(Product product) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.saveProduct(product);
    }

    @Override
    public void updatePflag(String pid) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.updatePflag(pid);
    }

    @Override
    public void updatePflagUp(String pid) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.updatePflagUp(pid);
    }

    @Override
    public void updateProductByPid(Product product) throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        productDao.updateProductByPid(product);
    }
}

package com.itcast.store.test;

import com.itcast.store.dao.OrderDao;
import com.itcast.store.dao.ProductDao;
import com.itcast.store.dao.UserDao;
import com.itcast.store.dao.impl.OrderDaoImpl;
import com.itcast.store.dao.impl.ProductDaoImpl;
import com.itcast.store.dao.impl.UserDaoImpl;
import com.itcast.store.domain.*;
import com.itcast.store.service.OrderService;
import com.itcast.store.service.ProductService;
import com.itcast.store.service.UserService;
import com.itcast.store.service.impl.OrderServiceImpl;
import com.itcast.store.service.impl.UserServiceImpl;
import com.itcast.store.utils.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void test1() throws Exception {
        Order order = new Order();
        List<OrderItem> list02 = new ArrayList<OrderItem>();
        String sql = "SELECT * from product p , orderitem o where o.pid = p.pid AND oid = 'A9F3F5ADC3844C3E8AF376E7DE649BA8'";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler());
        for (Map<String, Object> map : list) {
           /* for (Map.Entry<String, Object> entry : map.entrySet()) {
                //System.out.println("键："+entry.getKey()+"值："+entry.getValue());
            }*/
            OrderItem orderItem = new OrderItem();
            Product product = new Product();
            DateConverter dt = new DateConverter();
            // 2_设置转换的格式
            dt.setPattern("yyyy-MM-dd");
            // 3_注册转换器
            ConvertUtils.register(dt, java.util.Date.class);
            BeanUtils.populate(orderItem,map);
            BeanUtils.populate(product,map);

            orderItem.setProduct(product);

            list02.add(orderItem);
        }
    }
    @Test
    public  void  test2() throws SQLException {
        ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.findAllProductsWithPage(0, 5);
        System.out.println(list);

    }
    @Test
    public void tets3() throws Exception{
        OrderService orderService = new OrderServiceImpl();
        PageModel pm = orderService.findAllOrdersWithPage(1);
        System.out.println(pm);
    }
}

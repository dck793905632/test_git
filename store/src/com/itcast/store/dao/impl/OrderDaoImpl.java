package com.itcast.store.dao.impl;

import com.itcast.store.dao.OrderDao;
import com.itcast.store.domain.Order;
import com.itcast.store.domain.OrderItem;
import com.itcast.store.domain.Product;
import com.itcast.store.domain.User;
import com.itcast.store.utils.JDBCUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void saveOrder(Connection conn, Order order) throws Exception {
        String sql ="INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        Object[] parms = {order.getOid(),order.getOrdertime(),order.getTotal(),order.getState()
        ,order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid()};
        queryRunner.update(conn,sql,parms);
    }

    @Override
    public void saveOrderItem(Connection conn, OrderItem item) throws Exception {
        String sql = "INSERT INTO orderitem VALUES(?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        Object[] parms = {item.getItemid(),item.getQuantity(),item.getTotal(),item.getProduct().getPid()
            ,item.getOrder().getOid()};
        queryRunner.update(conn,sql,parms);
    }

    @Override
    public int getTotalRecords(User user) throws Exception {
        String sql = "select count(*) from orders where uid =?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Long totalRecords = (Long) queryRunner.query(sql,new ScalarHandler(),user.getUid());
        return totalRecords.intValue();
    }

    @Override
    public List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception {
        String sql = "select * from orders where uid = ? limit ?,?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> list =queryRunner.query(sql,new BeanListHandler<Order>(Order.class),user.getUid(),startIndex,pageSize);
        for (Order order : list) {
            String oid = order.getOid();
            String sql1 = "SELECT * from product p , orderitem o where o.pid = p.pid AND oid =?";
            List<Map<String, Object>> maps = queryRunner.query(sql1, new MapListHandler(), oid);
            for (Map<String, Object> map : maps) {
                Product product = new Product();
                OrderItem orderItem = new OrderItem();
                DateConverter dt = new DateConverter();
                // 2_设置转换的格式
                dt.setPattern("yyyy-MM-dd");
                // 3_注册转换器
                ConvertUtils.register(dt, java.util.Date.class);
                BeanUtils.populate(orderItem,map);
                BeanUtils.populate(product,map);
                //关联product到orderItem,订单项与商品信息关联
                orderItem.setProduct(product);
                //订单下的订单项集合与订单项关联
                order.getList().add(orderItem);
            }
        }
        return list;
    }

    @Override
    public Order findOrderByOid(String oid) throws Exception {
        String sql = "select * from orders where oid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Order order = queryRunner.query(sql, new BeanHandler<Order>(Order.class), oid);
        String sql1 = "SELECT * from product p , orderitem o where o.pid = p.pid AND oid =?";
        List<Map<String, Object>> maps = queryRunner.query(sql1, new MapListHandler(), oid);
        for (Map<String, Object> map : maps) {
           Product product = new Product();
           OrderItem orderItem = new OrderItem();
            DateConverter dt = new DateConverter();
            // 2_设置转换的格式
            dt.setPattern("yyyy-MM-dd");
            // 3_注册转换器
            ConvertUtils.register(dt, java.util.Date.class);
            BeanUtils.populate(orderItem,map);
            BeanUtils.populate(product,map);


            orderItem.setProduct(product);
            order.getList().add(orderItem);
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) throws Exception {
        String sql = "UPDATE orders SET ordertime = ? , total = ? ,state = ?,address = ?, name = ?, telephone = ? where oid = ?";
        Object[] parms = {order.getOrdertime(),order.getTotal(),order.getState()
                ,order.getAddress(),order.getName(),order.getTelephone(),order.getOid()};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,parms);
    }

    @Override
    public int getAllRecords() throws Exception {
        String sql = "select count(*) from orders";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Long totalRecords=(Long)queryRunner.query(sql,new ScalarHandler());
        return totalRecords.intValue();
    }

    @Override
    public List<Order> findAllOrdersWithPage() throws Exception {
        String sql = "select * from orders";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class));
        return list;
    }

    @Override
    public List<Order> findAllOrdersWithPageSt(int curNum, int st) throws Exception {
        String sql = "select * from orders where state = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class),st);
        return list;
    }

    @Override
    public void updateOrderState(String oid) throws Exception {
        String sql = "update orders set state = 3 where oid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,oid);
    }
}

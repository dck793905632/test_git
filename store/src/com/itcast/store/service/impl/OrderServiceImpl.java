package com.itcast.store.service.impl;

import com.itcast.store.dao.OrderDao;
import com.itcast.store.dao.impl.OrderDaoImpl;
import com.itcast.store.domain.Order;
import com.itcast.store.domain.OrderItem;
import com.itcast.store.domain.PageModel;
import com.itcast.store.domain.User;
import com.itcast.store.service.OrderService;
import com.itcast.store.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(Order order) throws Exception {
        //必须将订单信息和订单项信息同时保存到数据库中（同时成功，或者同时失败）！需要开启事务
        Connection conn=null;
        try {
            //获取连接
            conn= JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //保存订单
            OrderDao orderDao = new OrderDaoImpl();
            orderDao.saveOrder(conn,order);
            //保存订单项
            for (OrderItem item:order.getList()
                 ) {
                orderDao.saveOrderItem(conn,item);
            }
            //提交
            conn.commit();
        } catch (SQLException e) {
            //回滚
            conn.rollback();
        }

    }

    @Override
    public PageModel findMyOrdersWithPage(User user, int curNum) throws Exception {
        //创建OrderDao实体对象,查询数据库
        OrderDao orderDao = new OrderDaoImpl();
        //获取PageModel参数信息
        //获取所有的订单数量 select count(*) from orders where uid = ?
        int totalRecords = orderDao.getTotalRecords(user);
        //创建PageModel对象,传入参数获取分页信息
        PageModel pageModel = new PageModel(curNum,totalRecords,3);
        //select * from orders where uid = ? limit ?,?
        List list=orderDao.findMyOrdersWithPage(user,pageModel.getStartIndex(),pageModel.getPageSize());
        //关联集合
        pageModel.setList(list);
        //关联url
        pageModel.setUrl("OrderServlet?method=findMyOrdersWithPage");
        return pageModel;
    }

    @Override
    public Order findOrderByOid(String oid) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        return orderDao.findOrderByOid(oid);

    }

    @Override
    public void updateOrder(Order order) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.updateOrder(order);
    }

    @Override
    public PageModel findAllOrdersWithPage(int curNum) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        int totalRecords =orderDao.getAllRecords();
        //创建对象
        PageModel pageModel = new PageModel(curNum,totalRecords,10);
        //关联集合
        List<Order> list =orderDao.findAllOrdersWithPage();
        pageModel.setList(list);
        //关联url
        pageModel.setUrl("AdminOrderServlet?method=findAllOrdersWithPage");
        return pageModel;
    }

    @Override
    public PageModel findAllOrdersWithPageSt(int curNum,int st) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        int totalRecords =orderDao.getAllRecords();
        //创建对象
        PageModel pageModel = new PageModel(curNum,totalRecords,10);
        //关联集合
        List<Order> list =orderDao.findAllOrdersWithPageSt(curNum,st);
        pageModel.setList(list);
        //关联url
        pageModel.setUrl("AdminOrderServlet?method=findAllOrdersWithPage");
        return pageModel;
    }

    @Override
    public void updateOrderState(String oid) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.updateOrderState(oid);
    }
}

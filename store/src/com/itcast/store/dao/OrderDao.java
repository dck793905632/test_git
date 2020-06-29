package com.itcast.store.dao;

import com.itcast.store.domain.Order;
import com.itcast.store.domain.OrderItem;
import com.itcast.store.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    void saveOrder(Connection conn, Order order) throws Exception;

    void saveOrderItem(Connection conn, OrderItem item) throws Exception;

    int getTotalRecords(User user) throws Exception;

    List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception;

    Order findOrderByOid(String oid) throws Exception;

    void updateOrder(Order order) throws Exception;

    int getAllRecords() throws Exception;

    List<Order> findAllOrdersWithPage() throws Exception;

    List<Order> findAllOrdersWithPageSt(int curNum, int st) throws Exception;

    void updateOrderState(String oid) throws Exception;
}

package com.itcast.store.service;

import com.itcast.store.domain.Order;
import com.itcast.store.domain.PageModel;
import com.itcast.store.domain.User;

public interface OrderService {
    void saveOrder(Order order) throws Exception;

    PageModel findMyOrdersWithPage(User user, int curNum) throws Exception;

    Order findOrderByOid(String oid) throws Exception;

    void updateOrder(Order order) throws Exception;

    PageModel findAllOrdersWithPage(int curNum) throws Exception;

    PageModel findAllOrdersWithPageSt(int curNum,int st) throws Exception;

    void updateOrderState(String oid) throws Exception;
}

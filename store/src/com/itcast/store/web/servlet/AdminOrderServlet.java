package com.itcast.store.web.servlet;

import com.itcast.store.domain.Order;
import com.itcast.store.domain.PageModel;
import com.itcast.store.service.OrderService;
import com.itcast.store.service.impl.OrderServiceImpl;
import com.itcast.store.web.base.BaseServlet;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {
    //findAllOrdersWithPage
    public String findAllOrdersWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取首页
        int curNum=Integer.parseInt(request.getParameter("num"));
        //int st=Integer.parseInt(request.getParameter("state"));
        String st = request.getParameter("state");
        //调取数据库信息
        OrderService orderService = new OrderServiceImpl();
        PageModel pm = null;
        if(null==st||"".equals(st)){
            pm =orderService.findAllOrdersWithPage(curNum);
        }else {
            int st1 =Integer.parseInt(st);
            pm = orderService.findAllOrdersWithPageSt(curNum,st1);
        }
        //System.out.println(pm);
        //上传至request
        request.setAttribute("page",pm);
        //页面跳转至/order/list.jsp
        return "/admin/order/list.jsp";
    }
    //findOrderByOidWithAjax
    public String findOrderByOidWithAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取客户端传输的信息
        String oid=request.getParameter("id");

        //查询数据库信息
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.findOrderByOid(oid);
        //System.out.println(order);
        //将order中的orderItem转换为json字符串
        String jsonStr=JSONArray.fromObject(order.getList()).toString();
        //向客户端传递信息
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonStr);
        return null;
    }
    //updateOrderState
    public String updateOrderState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取需要修改订单的oid
        String oid=request.getParameter("oid");
        //修改信息
        OrderService orderService = new OrderServiceImpl();
        orderService.updateOrderState(oid);
        //重定向到已发货订单页面
        response.sendRedirect("/store/AdminOrderServlet?method=findAllOrdersWithPage&num=1&state=3");
        return null;
    }
}

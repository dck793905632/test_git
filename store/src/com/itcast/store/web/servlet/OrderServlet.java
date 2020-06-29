package com.itcast.store.web.servlet;

import com.itcast.store.domain.*;
import com.itcast.store.service.OrderService;
import com.itcast.store.service.impl.OrderServiceImpl;
import com.itcast.store.utils.PaymentUtil;
import com.itcast.store.utils.UUIDUtils;
import com.itcast.store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends BaseServlet {
    public String saveOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //确认用户登录状态,查找loginUser session
        User user=(User)request.getSession().getAttribute("loginUser");
        if(null==user){
            request.setAttribute("msg","请登录后再购买！");
            return "/jsp/info.jsp";
        }
        //获去购物车session
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        //创建订单对象,为订单对象赋值
        Order order = new Order();
        order.setOid(UUIDUtils.getCode());
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setState(1);

        order.setUser(user);

        //遍历购物项的同时,创建订单项
        for (CartItem item: cart.getcartItem()
             ) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UUIDUtils.getCode());
            orderItem.setQuantity(item.getNum());
            orderItem.setTotal(item.getSubTotal());

            orderItem.setProduct(item.getProduct());
            orderItem.setOrder(order);
            //将所有的订单项遍历放进list订单项集合中
            order.getList().add(orderItem);
        }
        //调用业务层功能:保存订单
        OrderService orderService = new OrderServiceImpl();
        orderService.saveOrder(order);
        //清空购物车
        cart.clearCart();
        //将订单放入request
        request.setAttribute("order",order);
        //转发/jsp/order_info.jsp
        return "/jsp/order_info.jsp";
    }
    //findMyOrdersWithPage
    public String findMyOrdersWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前页，loginUser
        User user =(User)request.getSession().getAttribute("loginUser");
        int curNum = Integer.parseInt(request.getParameter("num"));
        //创建OrderService 实体对象查询信息转换为PageModel型
        OrderService orderService = new OrderServiceImpl();
        //select * from orders where  uid = ? limit ? , ?
        PageModel pageModel =(PageModel)orderService.findMyOrdersWithPage(user,curNum);
        //将pageModel上传到requset中
        request.setAttribute("page",pageModel);
        //跳转页面到/jsp/order_list.jsp
        return "/jsp/order_list.jsp";
    }
    //findOrderByOid
    public String findOrderByOid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取order.oid
        String oid=request.getParameter("oid");
        //System.out.println(oid);
        //创建service对象，调取order信息
        OrderService orderService = new OrderServiceImpl();
        Order order=orderService.findOrderByOid(oid);
        //上传order到reque
        request.setAttribute("order",order);
        //转发到订单信息界面
        return "/jsp/order_info.jsp";
    }
    //PayServlet
    public String PayServlet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据，oid,name,address,telephone,银行卡
        String pd_FrpId = request.getParameter("pd_FrpId");
        String oid = request.getParameter("oid");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
       /* System.out.println(oid+","+name+","+address+","+telephone);*/
        //查出oid对应的order对象
        OrderService orderService = new OrderServiceImpl();
        Order order =orderService.findOrderByOid(oid);
        order.setAddress(address);
        order.setName(name);
        order.setTelephone(telephone);
        //将更新后的order对象重新插入到orders表中
        orderService.updateOrder(order);
        //向易宝支付发送参数
        // 把付款所需要的参数准备好:
        String p0_Cmd = "Buy";
        //商户编号
        String p1_MerId = "10001126856";
        //订单编号
        String p2_Order = oid;
        //金额
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        //接受响应参数的Servlet
        String p8_Url = "http://localhost:8080/store/OrderServlet?method=callBack";
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        //公司的秘钥
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

        //调用易宝的加密算法,对所有数据进行加密,返回电子签名
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);

        System.out.println(sb.toString());
        // 使用重定向：
        response.sendRedirect(sb.toString());
        return null;
    }
    //callBack
    public String callBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 验证请求来源和数据有效性
        // 阅读支付结果参数说明
        // System.out.println("==============================================");
        String p1_MerId = request.getParameter("p1_MerId");
        String r0_Cmd = request.getParameter("r0_Cmd");
        String r1_Code = request.getParameter("r1_Code");
        String r2_TrxId = request.getParameter("r2_TrxId");
        String r3_Amt = request.getParameter("r3_Amt");
        String r4_Cur = request.getParameter("r4_Cur");
        String r5_Pid = request.getParameter("r5_Pid");
        String r6_Order = request.getParameter("r6_Order");
        String r7_Uid = request.getParameter("r7_Uid");
        String r8_MP = request.getParameter("r8_MP");
        String r9_BType = request.getParameter("r9_BType");
        String rb_BankId = request.getParameter("rb_BankId");
        String ro_BankOrderId = request.getParameter("ro_BankOrderId");
        String rp_PayDate = request.getParameter("rp_PayDate");
        String rq_CardNo = request.getParameter("rq_CardNo");
        String ru_Trxtime = request.getParameter("ru_Trxtime");

        // hmac
        String hmac = request.getParameter("hmac");
        // 利用本地密钥和加密算法 加密数据
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
                r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
                r8_MP, r9_BType, keyValue);
        if (isValid) {
            // 有效
            if (r9_BType.equals("1")) {
                // 浏览器重定向
                response.setContentType("text/html;charset=utf-8");
                //如果支付成功，更新订单状态
                OrderService orderService = new OrderServiceImpl();
                Order order=orderService.findOrderByOid(r6_Order);
                order.setState(2);
                //向request发送信息
                request.setAttribute("msg","支付成功！订单号：" + r6_Order + "金额：" + r3_Amt);
                //跳转页面
                return "/jsp/info.jsp";
            } else if (r9_BType.equals("2")) {
                // 修改订单状态:
                // 服务器点对点，来自于易宝的通知
                System.out.println("收到易宝通知，修改订单状态！");//
                // 回复给易宝success，如果不回复，易宝会一直通知
                response.getWriter().print("success");
            }

        } else {
            throw new RuntimeException("数据被篡改！");
        }
        return null;
    }
}

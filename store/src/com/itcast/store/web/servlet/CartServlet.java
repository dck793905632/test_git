package com.itcast.store.web.servlet;

import com.itcast.store.domain.Cart;
import com.itcast.store.domain.CartItem;
import com.itcast.store.domain.Product;
import com.itcast.store.service.ProductService;
import com.itcast.store.service.impl.ProductServiceImpl;
import com.itcast.store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends BaseServlet {
    public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //判断cart session
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        //如果不存在，说明第一次购物，先创建新的cart session
        if(null==cart){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        //如果购物车已经存在进行添加操作
        //获取pid,购买数量quantity
        String pid=request.getParameter("pid");
        int num = Integer.parseInt(request.getParameter("quantity"));
        //从数据库中获取当前product数据
        ProductService productService = new ProductServiceImpl();
        Product product=productService.findProByPid(pid);
        //将product写入CartItem
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        //当前商品的数量
        cartItem.setNum(num);
        //将cartItem写入购物车
        cart.addCartItemToCart(cartItem);
        //重定向到购物车页面
        response.sendRedirect("/store/jsp/cart.jsp");
        //return "/jsp/cart.jsp";
        return null;
    }
    public String removeCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取session
         Cart cart =(Cart)request.getSession().getAttribute("cart");
         //获取pid
        String pid =request.getParameter("pid");
        //调用cart方法
        cart.removeCart(pid);
        //重定向到cart.jsp
        response.sendRedirect("/store/jsp/cart.jsp");
        return null;
    }
    //clearCart
    public String clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取购物车
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        //调用购物车方法
        cart.clearCart();
        //重定向
        response.sendRedirect("/store/jsp/cart.jsp");

        return null;
    }
}

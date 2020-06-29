package com.itcast.store.web.servlet;

import com.itcast.store.domain.PageModel;
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

@WebServlet(name = "ProductServlet")
public class ProductServlet extends BaseServlet {
    public String findProduceByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取pid
        String pid=request.getParameter("pid");
        //System.out.println(pid);
        //从数据库中查询获取商品信息
        ProductService productService = new ProductServiceImpl();
        Product product=productService.findProByPid(pid);
        //System.out.println(product);
        //将信息传输到request
        request.setAttribute("product",product);
        //跳转界面
        return "/jsp/product_info.jsp";
    }
    //findProductsByPidWithPage
    public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取页面传输信息
        String cid=request.getParameter("cid");
        int currNum=Integer.parseInt(request.getParameter("num"));
        //调用service方法，取出数据
        ProductService productService =new ProductServiceImpl();
        PageModel pm =productService.findProductsByCidWithPage(cid,currNum);
        //将数据上传到request
        request.setAttribute("page",pm);
        //跳转界面
        return "/jsp/product_list.jsp";
    }
}

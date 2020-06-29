package com.itcast.store.web.servlet;

import com.itcast.store.domain.Category;
import com.itcast.store.domain.Product;
import com.itcast.store.service.CategoryService;
import com.itcast.store.service.ProductService;
import com.itcast.store.service.impl.CategoryServiceImpl;
import com.itcast.store.service.impl.ProductServiceImpl;
import com.itcast.store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet")
public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      /*  //创建CategoryService对象，调出数据库集合信息
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list=categoryService.getAllCats();
        //将集合信息传输到request
        request.setAttribute("catsList",list);
        //request.getSession().setAttribute("catsList",list);
        //如过存到session里面，用户太多就需要每个人都存储一份session
        //跳转到首页*/
        //调用数据
        ProductService productService = new ProductServiceImpl();
        List<Product> list01=productService.findNews();
        List<Product> list02=productService.findHots();
        //将信息写入request
        request.setAttribute("news",list01);
        request.setAttribute("hots",list02);
        //跳转页面
        return "/jsp/index.jsp";
    }
}

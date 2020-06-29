package com.itcast.store.web.servlet;

import com.itcast.store.domain.Category;
import com.itcast.store.service.CategoryService;
import com.itcast.store.service.impl.CategoryServiceImpl;
import com.itcast.store.web.base.BaseServlet;


import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;

@WebServlet(name = "AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {
    //addCategoryUI
    public String addCategoryUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/category/add.jsp";
    }
    //getAllCats
    public String getAllCats(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取全部分类信息
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.getAllCats();
        //System.out.println(list);
        //上传到request
        request.setAttribute("allCats",list);
        //跳转界面
        return "/admin/category/list.jsp";
    }
    //addCategory
    public String addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取要添加的分类名称
        String cname = request.getParameter("cname");
        //创建service对象
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.addCategory(cname);

        List<Category> list = categoryService.getAllCats();
        //System.out.println(list);
        //上传到request
        request.setAttribute("allCats",list);
        //重定向界面
        response.sendRedirect("/store/AdminCategoryServlet?method=getAllCats");
        //return "/admin/category/list.jsp";
        //return "/admin/category/list.jsp";
        return  null;
    }
    //findCateByCid
    public String findCateByCid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取需要查询的cid
        String cid = request.getParameter("cid");
        //创建service对象
        CategoryService categoryService = new CategoryServiceImpl();
        Category category =categoryService.findCateByCid(cid);
        //将category上传到request
        request.setAttribute("category",category);
        //跳转页面
        return "/admin/category/edit.jsp";
    }
    //editCategoryByCid
    public String editCategoryByCid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取需要修改的商品种类cid,cname
        String cid  = request.getParameter("cid");
        String cname = request.getParameter("cname");

        //创建service对象
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.updateCategory(cid,cname);
        //重定向页面
        response.sendRedirect("/store/AdminCategoryServlet?method=getAllCats");
        //return "/admin/category/list.jsp";
        return null;
    }
    //deleteCategoryByCid
    public String deleteCategoryByCid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取商品cid
        String cid =request.getParameter("cid");
        //创建service对象调用删除方法
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.deleteCategoryByCid(cid);
        //重定向页面到list.jsp
        response.sendRedirect("/store/AdminCategoryServlet?method=getAllCats");
        //return "/admin/category/list.jsp";
        return null;
    }
}

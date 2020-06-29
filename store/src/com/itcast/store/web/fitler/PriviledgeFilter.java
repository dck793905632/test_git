package com.itcast.store.web.fitler;

import com.itcast.store.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "PriviledgeFilter")
public class PriviledgeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        //获取session中的值
        User user = (User) request1.getSession().getAttribute("loginUser");
        //判断session 中有没有user
        if(null!=user){
            //如果存在，放行
            chain.doFilter(request, response);
        }else {
            //不存在，进入提示界面，并提示信息
            request1.setAttribute("msg","请登陆后再进行操作！");
            request1.getRequestDispatcher("/jsp/info.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

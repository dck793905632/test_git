package com.itcast.store.web.servlet;

import com.itcast.store.domain.User;
import com.itcast.store.service.UserService;
import com.itcast.store.service.impl.UserServiceImpl;
import com.itcast.store.utils.MailUtils;
import com.itcast.store.utils.MyBeanUtils;
import com.itcast.store.utils.UUIDUtils;
import com.itcast.store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "UserServlet")
public class UserServlet extends BaseServlet {
    public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/jsp/register.jsp";

    }
    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/jsp/login.jsp";
    }
    public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/
        //接收表单参数
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        //日期格式转换
        MyBeanUtils.populate(user,map);
        user.setUid(UUIDUtils.getId());
        user.setCode(UUIDUtils.getCode());
        user.setState(0);
        //System.out.println(user);
        /*Set<String> keyset = map.keySet();
        Iterator<String> iterator = keyset.iterator();
        while (iterator.hasNext()){
            String str=iterator.next();
            System.out.println(str);
            String[] strings = map.get(str);
            for (String s:strings
                 ) {
                System.out.println(s);
            }

        }*/
        //调用业务层注册功能
        UserService userService = new UserServiceImpl();
        try {
            userService.registUser(user);
            //注册成功,向用户邮箱发送信息,跳转到提示页面
            MailUtils.sendMail(user.getEmail(),user.getCode());
            //request.setAttribute();
            request.setAttribute("msg","注册成功，请激活");
        } catch (Exception e) {
            e.printStackTrace();
            //注册失败,跳转到提示页面
            request.setAttribute("msg","注册失败，请重新激活");
        }
        return "/jsp/info.jsp";
    }
    public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {


            String code = request.getParameter("code");
            UserService userService = new UserServiceImpl();
            boolean flag = userService.userActive(code);
            if(flag==true){
                //userService.updateState(code);
                //激活成功
                request.setAttribute("msg","激活成功，请登录！");
                return "/jsp/login.jsp";
            }else {
                //激活失败
                request.setAttribute("msg","激活失败，请重新激活！");
                return "/jsp/info.jsp";
            }
    }
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名密码
        Map<String, String[]> map = request.getParameterMap();
        User user =new User();
        MyBeanUtils.populate(user,map);
        UserService userService =new UserServiceImpl();
        User user1=null;
        try {
            user1=userService.loginUser(user);
            //登录成功，将user存入session
            request.getSession().setAttribute("loginUser",user1);
            //登陆成功跳转
            response.sendRedirect("/store/index.jsp");
            return null;
        } catch (Exception e) {
            //登录失败,获取失败返回信息
            String msg=e.getMessage();
            request.setAttribute("msg",msg);
            return "/jsp/login.jsp";
        }
    }
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //清空session
        request.getSession().invalidate();
        //返回界面
        response.sendRedirect("/store/index.jsp");
        return null;
    }
}

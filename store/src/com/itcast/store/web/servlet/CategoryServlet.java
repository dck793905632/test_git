package com.itcast.store.web.servlet;

import com.itcast.store.domain.Category;
import com.itcast.store.service.CategoryService;
import com.itcast.store.service.impl.CategoryServiceImpl;
import com.itcast.store.utils.JedisUtils;
import com.itcast.store.web.base.BaseServlet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "CategoryServlet")
public class CategoryServlet extends BaseServlet {
    public String findAllCats(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获得redis实例
        Jedis jedis = JedisUtils.getJedis();
        String jsonStr=jedis.get("allCats");
        if(jsonStr==null||"".equals(jsonStr)){
            //获取信息
            CategoryService categoryService = new CategoryServiceImpl();
            List<Category> list = categoryService.getAllCats();
            //转换
            jsonStr=JSONArray.fromObject(list).toString();
            //System.out.println(json);
            //将jsonStr存入redis
            jedis.set("allCats",jsonStr);
            //发送数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(jsonStr);

        }else {
            //发送数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(jsonStr);
        }
        JedisUtils.closeJedis(jedis);
        return null;
    }
}

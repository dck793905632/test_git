package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    //跳转到后台管理主页
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    //进行tree跳转
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page ){
        return page;
    }


}

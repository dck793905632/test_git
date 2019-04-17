package com.taotao.portal.controller;


import com.taotao.portal.pojo.SearchResult;
import com.taotao.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Contended;

import java.io.UnsupportedEncodingException;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
    public String search(@RequestParam("q") String queryString,@RequestParam(defaultValue = "1") Integer page, Model model){
        if(queryString!=null){
            try {
                queryString = new String(queryString.getBytes("iso8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        SearchResult result = searchService.search(queryString, page);
        model.addAttribute("Query",queryString);
        model.addAttribute("totalPages",result.getRecordCount());
        model.addAttribute("itemList",result.getItemList());
        model.addAttribute("Page",page);
        return "search";
    }
}

package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;

    //查询内容/content/query/list
    @RequestMapping("/content/query/list")
    @ResponseBody
    public EUDataGridResult selectContentList(long categoryId, Integer page, Integer rows){
        EUDataGridResult result = contentService.selectContentList(categoryId, page, rows);
        return result;
    }
    //添加内容
    @RequestMapping("/content/save")
    @ResponseBody
    public TaotaoResult insertContent(TbContent content){
        TaotaoResult result = contentService.insertContent(content);
        return result;
    }
    //修改内容/rest/content/edit
    @RequestMapping("/rest/content/edit")
    @ResponseBody
    public TaotaoResult updateContent(TbContent tbContent){
        contentService.upadteContent(tbContent);
        return TaotaoResult.ok();
    }
    //删除内容/content/delete
    @RequestMapping("/content/delete")
    @ResponseBody
    public TaotaoResult deleteContentById(@RequestParam("ids") long[] id){
        TaotaoResult result = new TaotaoResult();
        for (long ids : id) {
            result = contentService.deleteContentById(ids);
        }
        return result;
    }
}

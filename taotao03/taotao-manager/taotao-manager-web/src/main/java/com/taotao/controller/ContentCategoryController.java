package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    //查询分类列表
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getCategoryList(@RequestParam(value = "id" , defaultValue = "0") long parentId){
        List<EUTreeNode> categoryList = contentCategoryService.getCategoryList(parentId);
        return categoryList;
    }

    //添加分类列表
    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult insertContentCategory(long parentId, String name){
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }

    //删除分类
    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteCategory(long id){
        contentCategoryService.deleteCategory(id);
        return TaotaoResult.ok();
    }
    //更改分类名称
    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateCategory(long id ,String name){
        contentCategoryService.updateCategory(id,name);
        return TaotaoResult.ok();
    }


}

package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    //查询列表/item/param/list
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemParamList(Integer page , Integer rows){
        EUDataGridResult itemParamList = itemParamService.getItemParamList(page, rows);

        return itemParamList;
    }


    //查询是否已经存在信息
    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId){
        TaotaoResult result = itemParamService.getItemParamByCid(itemCatId);
        return result;
    }

    //增加分类模板
    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){
        //创建对象
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        TaotaoResult result = itemParamService.insertItemParam(itemParam);
        return result;
    }
    //删除"/item/param/delete"
    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteItemParams(@RequestParam("ids") long[] id){
        TaotaoResult result = new TaotaoResult();
        for (long ids : id) {
            result = itemParamService.deleteItemParams(ids);
        }
        return result;
    }
}

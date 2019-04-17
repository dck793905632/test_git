package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    //商品列表查询带分页
    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows){
        EUDataGridResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }
    //添加商品
    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult addItem(TbItem tbItem,String desc,String itemParams) throws Exception {
        TaotaoResult result = itemService.addItem(tbItem,desc,itemParams);
        return result;
    }
    //删除商品"/rest/item/delete"
    @RequestMapping("/rest/item/delete")
    @ResponseBody
    public TaotaoResult deleteItemsById(@RequestParam("ids") long[] id){
        TaotaoResult result = new TaotaoResult();
        for (long ids : id) {
            result = itemService.deleteItemsById(ids);
        }
        return result;
    }
    //下架商品/rest/item/instock
    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public TaotaoResult instock(@RequestParam("ids") long[] id){
        TaotaoResult result = new TaotaoResult();
        for (long ids : id) {
            result = itemService.instock(ids);
        }
        return result;
    }
    //上架商品/rest/item/reshelf
    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public TaotaoResult reshelf(@RequestParam("ids") long[] id){
        TaotaoResult result = new TaotaoResult();
        for (long ids : id) {
            result = itemService.reshelf(ids);
        }
        return result;
    }
    //修改商品/rest/item/update


}

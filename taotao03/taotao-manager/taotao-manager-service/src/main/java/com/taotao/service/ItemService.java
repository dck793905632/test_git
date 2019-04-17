package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbUser;

public interface ItemService {
    TbItem getItemById(long itemId);
    //商品列表查询带分页
    EUDataGridResult getItemList(Integer page,Integer rows);
    //添加商品
    TaotaoResult addItem(TbItem tbItem,String desc,String itemParams)throws Exception;
    //删除商品
    TaotaoResult deleteItemsById(long id);
    //下架
    TaotaoResult instock(long ids);
    //上架
    TaotaoResult reshelf(long ids);
}

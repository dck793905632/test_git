package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;
    @Override
    public TbItem getItemById(long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }
    //商品列表查询带分页
    @Override
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        //创建EU对象
        EUDataGridResult result = new EUDataGridResult();
        //执行sql语句
        TbItemExample example = new TbItemExample();
        //PageHelper
        PageHelper.startPage(page,rows);
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);
        //Info对象
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        long total = pageInfo.getTotal();
        result.setTotal(total);
        result.setRows(tbItems);
        return result;
    }
    @Override
    public TaotaoResult addItem(TbItem tbItem,String desc,String itemParams) throws Exception {
        //补全tbitem
        tbItem.setStatus((byte) 1);
        tbItem.setUpdated(new Date());
        tbItem.setCreated(new Date());
        long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        //执行sql语句
        tbItemMapper.insert(tbItem);
        //插入商品名描述
        TaotaoResult result = insertDesc(itemId, desc);
        if(result.getStatus()!=200){
            throw  new Exception();
        }
        result=insertItemParams(itemId,itemParams);
        if(result.getStatus()!=200){
            throw  new Exception();
        }
        return TaotaoResult.ok();
    }

    //删除信息
    @Override
    public TaotaoResult deleteItemsById(long id) {
        tbItemMapper.deleteByPrimaryKey(id);
        return TaotaoResult.ok();
    }

    //下架
    @Override
    public TaotaoResult instock(long ids) {
        //查询对应的商品
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(ids);
        tbItem.setStatus((byte) 2);
        tbItemMapper.updateByPrimaryKeySelective(tbItem);
        return TaotaoResult.ok();
    }
    //将下架商品变为上架商品
    @Override
    public TaotaoResult reshelf(long ids) {
        //查询对应商品
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(ids);
        //更改商品状态
        tbItem.setStatus((byte) 1);
        //更新商品
        tbItemMapper.updateByPrimaryKeySelective(tbItem);
        return TaotaoResult.ok();
    }

    //添加富文本信息
    private TaotaoResult insertDesc(Long itemId,String desc){
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        tbItemDesc.setItemDesc(desc);
        //插入数据库
        itemDescMapper.insert(tbItemDesc);
        return TaotaoResult.ok();
    }
    //添加商品描述信息
    private TaotaoResult insertItemParams(Long itemId,String itemParams){
        //补全信息
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        itemParamItem.setParamData(itemParams);
        //执行sql语句
        itemParamItemMapper.insert(itemParamItem);
        //返回Tao
        return TaotaoResult.ok();
    }
}
